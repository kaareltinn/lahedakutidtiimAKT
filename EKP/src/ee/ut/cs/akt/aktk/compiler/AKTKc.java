package ee.ut.cs.akt.aktk.compiler;

import static org.objectweb.asm.Opcodes.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

import ee.ut.cs.akt.aktk.ast.*;
import ee.ut.cs.akt.aktk.parser.ParsingUtils;


public class AKTKc {
	
	private static Map<String, Integer> variableIndices = new HashMap<String, Integer>();
	
	public static void main(String[] args) throws IOException {
		// lihtsam viis "käsurea parameetrite andmiseks":
		//args = new String[] {"signs.aktk"};
		
		
		if (args.length != 1) {
			throw new IllegalArgumentException("Sellele programmile tuleb anda parameetriks kompileeritava AKTK faili nimi");
		}
		
		File file = new File(args[0]);
		if (!file.exists()) {
			throw new IllegalArgumentException("Ei leia faili nimega '"+file+"'");
		}
		
		
		String className = file.getName().replace(".aktk", "");
		File dir = file.getAbsoluteFile().getParentFile();
				
		createClassFile(file, className, dir);
	}
	
	private static void createClassFile(File sourceFile, String className, File outputFolder) throws IOException {
		// loen faili sisu muutujasse
		Scanner sc = new Scanner(sourceFile, "UTF-8");
		sc.useDelimiter("^"); 
		String source = sc.next();
		sc.close();
		
		// parsin ja moodustan AST'i
		AstNode ast = ParsingUtils.createAst(source);
		
		FileOutputStream out = new FileOutputStream(className + ".class"); 
		out.write(createClass(ast, className));
		out.close();
	}
	
		
	
	public static byte[] createClass(AstNode ast, String className) {
 
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		
		
		
		// Klassi attribuudid
		cw.visit(V1_7, ACC_PUBLIC + ACC_SUPER, className, null, "java/lang/Object", null);
		cw.visitSource(null, null);
		
		// main meetod
		MethodVisitor mv = cw.visitMethod(
				ACC_PUBLIC + ACC_STATIC, 					// modifikaatorid
				"main",										// meetodi nimi
				"([Ljava/lang/String;)V",					// meetodi kirjeldaja
				null, 										// geneerikute info
				new String[] { "java/io/IOException" });
		mv.visitCode();
		// terve AKTK programm tuleb kompileerida main meetodi sisse
		generateCode(ast, mv);
		mv.visitInsn(RETURN);
		mv.visitMaxs(0, 0);
		mv.visitEnd();
		
		
		// klassi lõpetamine
		cw.visitEnd();
		
		// klassi baidijada genereerimine
		return cw.toByteArray();
	}
	
	private static int getVariableIndex(String name) {
		Integer index = variableIndices.get(name);
		if (index != null) {
			return index;
		} 
		else {
			// muutuja 0 on meie main-meetodi parameeter
			
			index = variableIndices.size()+1;
			variableIndices.put(name, index);
			return index;
		}
	}
	
	private static void generateCode(AstNode node, MethodVisitor mv) {
		if (node instanceof Block) {
			for (Statement stmt : ((Block)node).getStatements()) {
				generateCode(stmt, mv);
			}
		}
		else if (node instanceof Assignment) {
			generateCode(((Assignment) node).getExpression(), mv);
			// eeldan, et kõik väärtused on täisarvud
			mv.visitVarInsn(ISTORE, getVariableIndex(((Assignment) node).getVariableName()));
		}
		else if (node instanceof ExpressionStatement) {
			generateCode(((ExpressionStatement) node).getExpression(), mv);
			// viska minema avaldise poolt arvutatud väärtus
			mv.visitInsn(POP);
		}
		else if (node instanceof IntegerLiteral) {
			mv.visitLdcInsn(((IntegerLiteral) node).getValue());
		}
		else if (node instanceof Variable) {
			mv.visitVarInsn(ILOAD, getVariableIndex(((Variable) node).getName()));
		}
		else if (node instanceof VariableDeclaration) {
			VariableDeclaration vardec = (VariableDeclaration) node;
			if (vardec.getInitializer() != null) {
				generateCode(vardec.getInitializer(), mv);
				mv.visitVarInsn(ISTORE, getVariableIndex(vardec.getVariableName()));
			}
		}
		else if (node instanceof FunctionCall) {
			FunctionCall call = (FunctionCall) node;
			
			if (call.getFunctionName().equals("-") && call.getArguments().size() == 1) { 
				// unaarne miinus
				generateCode(call.getArguments().get(0), mv);
				mv.visitInsn(INEG);				
			}
			else if (call.isArithmeticOrLogicOperation()) {
				generateArithmeticOrLogicOperation(call, mv);
			}
			else if (call.isComparisonOperation()) {
				generateComparisonOperation(call, mv);
			}
			else {
				generateNormalFunctionCall(call, mv);
			}
		}
		else if (node instanceof IfStatement) {
			IfStatement stmt = (IfStatement) node;
			
			Label doneLabel = new Label();
			Label elseLabel = new Label();
			
			// genereeri tingimuse väärtustamise kood
			generateCode(stmt.getCondition(), mv);
			
			// kui tulemuseks oli 0, siis hüppan else harusse
			// vastasel juhul jätkan then haruga ja hüppan konstruktsiooni lõppu
			mv.visitJumpInsn(IFEQ, elseLabel);
			
			generateCode(stmt.getThenBranch(), mv);
			mv.visitJumpInsn(GOTO, doneLabel);
			
			mv.visitLabel(elseLabel);
			generateCode(stmt.getElseBranch(), mv);
			
			mv.visitLabel(doneLabel);
		}
		else if (node instanceof WhileStatement) {
			WhileStatement stmt = (WhileStatement) node;
			Label startLabel = new Label();
			Label doneLabel = new Label();
			
			mv.visitLabel(startLabel);
			// genereeri tingimuse väärtustamise kood
			generateCode(stmt.getCondition(), mv);
			
			// kui tulemuseks oli 0, siis hüppan lõppu
			// vastasel juhul jätkan tsükli kehaga
			mv.visitJumpInsn(IFEQ, doneLabel);
			
			generateCode(stmt.getBody(), mv);
			// mine uuesti tsükli algusse, tingimust kontrollima 
			mv.visitJumpInsn(GOTO, startLabel);
			
			mv.visitLabel(doneLabel);
		}
		else {
			assert node instanceof FloatingPointLiteral 
				|| node instanceof StringLiteral;
			
			throw new UnsupportedOperationException("Seda konstrutsiooni praegu me ei toeta");
		}
	}
	
	private static void generateNormalFunctionCall(FunctionCall call, MethodVisitor mv) {
		// kõigepealt tuleb genereerida argumentide väärtustamise kood
		// Samal ajal panen kokku argumentide tüübikirjelduse
		String argTypedesc = "";
		for (Expression arg : call.getArguments()) {
			generateCode(arg, mv);
			argTypedesc += "I";
		}
		mv.visitMethodInsn(
				INVOKESTATIC,
				"ee/ut/cs/aktk/aktk/library/AKTKBuiltins",
				call.getFunctionName(),
				"("+argTypedesc+")I",
				false);
	}
	
	private static void generateArithmeticOrLogicOperation(FunctionCall call, MethodVisitor mv) {
		assert call.getArguments().size() == 2;
		
		// genereeri argumentide väärtustamise kood
		generateCode(call.getArguments().get(0), mv);
		generateCode(call.getArguments().get(1), mv);
		
		switch (call.getFunctionName()) {
		case "+": mv.visitInsn(IADD); break;
		case "-": mv.visitInsn(ISUB); break;
		case "*": mv.visitInsn(IMUL); break;
		case "/": mv.visitInsn(IDIV); break;
		case "%": mv.visitInsn(IREM); break;
//		case "&": mv.visitInsn(IAND); break; // neid praegu parser ei toeta niikuinii
//		case "|": mv.visitInsn(IOR); break;
//		case "^": mv.visitInsn(IXOR); break;
//		case "<<": mv.visitInsn(ISHL); break;
//		case ">>": mv.visitInsn(ISHR); break;
//		case ">>>": mv.visitInsn(IUSHR); break;
		default: throw new UnsupportedOperationException();
		}
	}
	
	private static void generateComparisonOperation(FunctionCall call, MethodVisitor mv) {
		assert call.getArguments().size() == 2;
		
		// Rikkalik võrdlusoperatsioonide valik on seotud jumpidega,
		// aga kuna ma ei taha avaldise väärtustamise koodi siduda if-lausega
		// siis ma kasutan jumpe lihtsalt selleks, et tekitada stacki tippu 
		// kas 0 või 1
		
		Label trueLabel = new Label(); 
		Label doneLabel = new Label(); 
		generateCode(call.getArguments().get(0), mv);
		generateCode(call.getArguments().get(1), mv);
		
		// genereerin operatsiooni, mis hüppab true väärtuse genereerimise juurde
		// kui näidatud seos kehtib
		switch (call.getFunctionName()) {
		case ">": mv.visitJumpInsn(IF_ICMPGT, trueLabel); break;
		case "<": mv.visitJumpInsn(IF_ICMPLT, trueLabel); break;
		case ">=": mv.visitJumpInsn(IF_ICMPGE, trueLabel); break;
		case "<=": mv.visitJumpInsn(IF_ICMPLE, trueLabel); break;
		case "==": mv.visitJumpInsn(IF_ICMPEQ, trueLabel); break;
		case "!=": mv.visitJumpInsn(IF_ICMPNE, trueLabel); break;
		default: throw new UnsupportedOperationException();
		}
		
		// kui hüpet ei toimunud, siis järelikult seos ei kehtinud, 
		mv.visitInsn(ICONST_0);
		mv.visitJumpInsn(GOTO, doneLabel);
		
		mv.visitLabel(trueLabel);
		mv.visitInsn(ICONST_1);
		
		mv.visitLabel(doneLabel);
	}
}
