package ee.ut.cs.akt.aktk.compiler;

import static org.objectweb.asm.Opcodes.*;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

import ee.ut.cs.akt.aktk.ast.Type;
import ee.ut.cs.akt.aktk.checker.StaticChecker;
import org.objectweb.asm.*;

import ee.ut.cs.akt.aktk.ast.*;
import ee.ut.cs.akt.aktk.parser.ParsingUtils;

import javax.swing.*;


public class EKPc {
	
	private static Map<String, Integer> variableIndices = new HashMap<String, Integer>();

    static Map<String, VariableDeclaration> vardecs = new HashMap<>();
    static List<AstNode> fundecs = new ArrayList<>();
    static Map<String, String> returnTypes = new HashMap<>();




    public static void main(String[] args) throws IOException {
		// lihtsam viis "käsurea parameetrite andmiseks":
		args = new String[] {"test.ekp"};

		if (args.length != 1) {
			throw new IllegalArgumentException("Sellele programmile tuleb anda parameetriks kompileeritava EKP faili nimi");
		}
		
		File file = new File(args[0]);
		if (!file.exists()) {
			throw new IllegalArgumentException("Ei leia faili nimega '"+file+"'");
		}
		
		
		String className = file.getName().replace(".ekp", "");
		File dir = file.getAbsoluteFile().getParentFile();

        fillMapWithReturnTypes(returnTypes);


        createClassFile(file, className, dir);

        try {
            runClass(className);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void runClass(String className) throws IOException, InterruptedException {
        int result;

        try {

            System.out.println("command output:");
            Process proc = Runtime.getRuntime().exec("java -cp ./bin;./lib/antlr-runtime-4.2.2.jar;./lib/asm-5.0.2.jar -Dfile.encoding=utf8 " + className);

            InputStream errin = proc.getErrorStream();
            InputStream in = proc.getInputStream();
            BufferedReader errorOutput = new BufferedReader(new InputStreamReader(errin));
            BufferedReader output = new BufferedReader(new InputStreamReader(in));
            String line1 = null;
            String line2 = null;
            try {
                while ((line1 = errorOutput.readLine()) != null ||
                        (line2 = output.readLine()) != null) {
                    if(line1 != null) System.out.println(line1);
                    if(line2 != null) System.out.println(line2);
                }//end while
                errorOutput.close();
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }//end catc
            result = proc.waitFor();
        } catch (IOException e) {
            System.err.println("IOException raised: " + e.getMessage());
        }
    }


	private static void createClassFile(File sourceFile, String className, File outputFolder) throws IOException {
		// loen faili sisu muutujasse
		Scanner sc = new Scanner(sourceFile, "UTF-8");
		sc.useDelimiter("^"); 
		String source = sc.next();
		sc.close();
		
		// parsin ja moodustan AST'i
		AstNode ast = ParsingUtils.createAst(source);
        //System.out.println(ast.toString());
        //StaticChecker.check(ast);


        FileOutputStream out = new FileOutputStream(outputFolder + "/bin/" + className + ".class");

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

        //deklareeritud meetodite loomine

        for (AstNode funNode : fundecs) {
            generateFunction(funNode, cw);
        }

		// klassi lõpetamine
		cw.visitEnd();
		
		// klassi baidijada genereerimine
		return cw.toByteArray();
	}

    private static void generateFunction(AstNode funNode, ClassWriter cw) {

        String funName = ((FunctionDeclaration)funNode).getFunctionName();
        List<VariableDeclaration> arguments = ((FunctionDeclaration)funNode).getArguments();
        //Type returnType= ((FunctionDeclaration)funNode).getFunctionReturnType();
        Expression returnExp = ((FunctionDeclaration)funNode).getFunctionReturnExpression();
        Statement funState= ((FunctionDeclaration)funNode).getFunctionStatment();

        String argTypedesc = "";
        for (VariableDeclaration var : arguments) {
            Type arg = var.getType();
            argTypedesc += returnType(arg);

        }


        MethodVisitor mv = cw.visitMethod(
                ACC_PUBLIC + ACC_STATIC, 					    // modifikaatorid
                funName,										// meetodi nimi
                "(" + argTypedesc + ")" + getArgType(returnExp),// meetodi kirjeldaja
                null, 										    // geneerikute info
                null);
        mv.visitCode();
        generateCode(funState, mv);
        if(returnExp instanceof Variable){
            mv.visitVarInsn(ILOAD, variableIndices.get(((Variable) returnExp).getName()));

        }else{
            mv.visitLdcInsn(((IntegerLiteral) returnExp).getValue());
        }
        mv.visitInsn(IRETURN);

        //generateCode(returnExp, mv);
        mv.visitMaxs(0, 0);
        mv.visitEnd();

    }

    private static Integer getVariableIndex(String name) {

        Integer index;

        index = variableIndices.get(name);


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
            Expression exp = ((Assignment) node).getExpression();

            String varname =((Assignment) node).getVariableName();
            if(!(exp instanceof FunctionCall)){

                Type arg1 = new SimpleType(exp.toString());
                VariableDeclaration vardec = new VariableDeclaration(varname, arg1, exp);
                vardecs.put(varname, vardec);
                if(exp instanceof IntegerLiteral){
                    mv.visitVarInsn(ISTORE, getVariableIndex(varname));
                }else if(exp instanceof FloatingPointLiteral){
                    mv.visitVarInsn(DSTORE, getVariableIndex(varname));
                }else{
                    mv.visitVarInsn(ASTORE, getVariableIndex(varname));
                }

            }else{
                String type ="";
                FunctionCall call = (FunctionCall) exp;
                String funName = ((FunctionCall) exp).getFunctionName();
                if((call.equals("-") && call.getArguments().size() == 1) || call.isArithmeticOrLogicOperation()|| call.isComparisonOperation()){
                    type = getArgType(call.getArguments().get(0));

                }else {
                    type = returnTypes.get(funName);
                }
                    if (type.equals("I")) {
                        mv.visitVarInsn(ISTORE, getVariableIndex(varname)); //kui erinevad tagastustüübid siis muuta seda
                    } else if (type.equals("D")) {
                        mv.visitVarInsn(DSTORE, getVariableIndex(varname));
                    } else {
                        mv.visitVarInsn(ASTORE, getVariableIndex(varname));
                    }


            }





		}
		else if (node instanceof ExpressionStatement) {
			generateCode(((ExpressionStatement) node).getExpression(), mv);
			// viska minema avaldise poolt arvutatud väärtus
			mv.visitInsn(POP);
		}
		else if (node instanceof IntegerLiteral) {
			mv.visitLdcInsn(((IntegerLiteral) node).getValue());
		}

        else if (node instanceof FloatingPointLiteral) {
            mv.visitLdcInsn(((FloatingPointLiteral) node).getValue());
        }

        else if (node instanceof StringLiteral) {
            mv.visitLdcInsn(((StringLiteral) node).getValue());
        }

		else if (node instanceof Variable) {

            Variable var = ((Variable) node);
            VariableDeclaration vardec = vardecs.get(var.getName());

            Expression exp = (vardec.getInitializer());
            if(exp instanceof IntegerLiteral){
                mv.visitVarInsn(ILOAD, getVariableIndex(((Variable) node).getName()));
            }else if(exp instanceof FloatingPointLiteral){
                mv.visitVarInsn(DLOAD, getVariableIndex(((Variable) node).getName()));
            }else{
                mv.visitVarInsn(ALOAD, getVariableIndex(((Variable) node).getName()));
            }
		}
		else if (node instanceof VariableDeclaration) {
			VariableDeclaration vardec = (VariableDeclaration) node;

            vardecs.put(vardec.getVariableName(), vardec);

            //System.out.println(vardec.getInitializer() + Boolean.toString(vardecs.containsKey(vardec.getVariableName())) + vardecs.get(vardec.getVariableName()).getInitializer());


            if (vardec.getInitializer() != null) {
				generateCode(vardec.getInitializer(), mv);
                Expression exp = vardec.getInitializer();

                if(exp instanceof IntegerLiteral){
                    mv.visitVarInsn(ISTORE, getVariableIndex(vardec.getVariableName()));
                }else if(exp instanceof FloatingPointLiteral){
                    mv.visitVarInsn(DSTORE, getVariableIndex(vardec.getVariableName()));
                }else{
                    mv.visitVarInsn(ASTORE, getVariableIndex(vardec.getVariableName()));
                }
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
            if(stmt.getElseBranch() != null){
                generateCode(stmt.getElseBranch(), mv);

            }

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
		}else if( node instanceof FunctionDeclaration){
            fundecs.add(node);
        }
		else {
			throw new UnsupportedOperationException("Seda konstrutsiooni praegu me ei toeta");
		}
	}
	
	private static void generateNormalFunctionCall(FunctionCall call, MethodVisitor mv) {
		// kõigepealt tuleb genereerida argumentide väärtustamise kood
		// Samal ajal panen kokku argumentide tüübikirjelduse
		String argTypedesc = "";
		for (Expression arg : call.getArguments()) {
            generateCode(arg, mv);
            argTypedesc += getArgType(arg);
        }

        //System.out.println(call.getFunctionName() + " " + returnTypes.get(call.getFunctionName()));


        mv.visitMethodInsn(
                INVOKESTATIC,
                "ee/ut/cs/akt/aktk/library/Builtins",
                call.getFunctionName(),
                "(" + argTypedesc + ")" + returnTypes.get(call.getFunctionName()), //Tagastus väärtus muuta
                false);
	}
	
	private static void generateArithmeticOrLogicOperation(FunctionCall call, MethodVisitor mv) {
		assert call.getArguments().size() == 2;
		
		// genereeri argumentide väärtustamise kood
		generateCode(call.getArguments().get(0), mv);
		generateCode(call.getArguments().get(1), mv);

        Expression exp = call.getArguments().get(0);

        if(getArgType(exp).equals("I")){
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
        }else if(getArgType(exp).equals("D")){
            switch (call.getFunctionName()) {
                case "+": mv.visitInsn(DADD); break;
                case "-": mv.visitInsn(DSUB); break;
                case "*": mv.visitInsn(DMUL); break;
                case "/": mv.visitInsn(DDIV); break;
                case "%": mv.visitInsn(DREM); break;
//		case "&": mv.visitInsn(IAND); break; // neid praegu parser ei toeta niikuinii
//		case "|": mv.visitInsn(IOR); break;
//		case "^": mv.visitInsn(IXOR); break;
//		case "<<": mv.visitInsn(ISHL); break;
//		case ">>": mv.visitInsn(ISHR); break;
//		case ">>>": mv.visitInsn(IUSHR); break;
                default: throw new UnsupportedOperationException();
            }
        }else{
            throw new UnsupportedOperationException();
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

    public static String getArgType(Expression arg){

        if(arg instanceof Variable){
            VariableDeclaration vardec = vardecs.get(((Variable) arg).getName());

            arg = (vardec.getInitializer());
        }else if(arg instanceof FunctionCall){
            return returnTypes.get(((FunctionCall) arg).getFunctionName());
        }

        if(arg instanceof IntegerLiteral){
            return "I";
        }else if(arg instanceof FloatingPointLiteral){
            return "D";
        }else{
            return "Ljava/lang/String;"; //string
        }
    }

    public static String returnType(Type arg){


        if(arg.equals(new SimpleType("täisarv"))){
            return "I";
        }else if(arg.equals(new SimpleType("ujukomaarv"))){
            return "D";
        }else{
            return "Ljava/lang/String;"; //string
        }
    }

    public static void fillMapWithReturnTypes(Map<String, String> returnTypes) {
        try {
            Class<?> c = Class.forName("ee.ut.cs.akt.aktk.library.Builtins");
            Method[] allMethods = c.getDeclaredMethods();
            for (Method m : allMethods) {
                String type = translateToASM(m.getReturnType().getName());
                if(type != null){
                    returnTypes.put(m.getName(), type);
                }


            }
            // production code should handle these exceptions more gracefully
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    public static String translateToASM(String type){
        if(type.equals("int")){
            return "I";
        }else if(type.equals("double")){
            return "D";
        }else if(type.equals("java.lang.String")){
            return "Ljava/lang/String;";
        }else{
            return null;
        }
    }

    public static void createClassFileFromString(String text, String className, String dir) throws IOException {

        fillMapWithReturnTypes(returnTypes);

        // parsin ja moodustan AST'i
        AstNode ast = ParsingUtils.createAst(text.trim());
        //system.out.println(ast.toString());
        StaticChecker.check(ast);


        FileOutputStream out = new FileOutputStream(dir + "/bin/" + className + ".class");

        out.write(createClass(ast, className));
        out.close();
    }

    public static void runClassInIDE(String className, JEditorPane console) throws IOException, InterruptedException {
        int result;

        try {

            Process proc = Runtime.getRuntime().exec("java -cp ./bin;./lib/antlr-runtime-4.2.2.jar;./lib/asm-5.0.2.jar -Dfile.encoding=utf8 " + className);

            InputStream errin = proc.getErrorStream();
            InputStream in = proc.getInputStream();
            BufferedReader errorOutput = new BufferedReader(new InputStreamReader(errin));
            BufferedReader output = new BufferedReader(new InputStreamReader(in));
            String line1 = null;
            String line2 = null;
            String sout = "";
            String serr = "";
            try {
                while ((line1 = errorOutput.readLine()) != null ||
                        (line2 = output.readLine()) != null) {
                    if(line1 != null) serr += line1 + "\n";
                    if(line2 != null) sout += line2 + "\n";
                }//end while
                errorOutput.close();
                output.close();
                if(!serr.equals("")){
                    console.setText(serr);
                }else{
                    console.setText(sout);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }//end catc
            result = proc.waitFor();
        } catch (IOException e) {
            System.err.println("IOException raised: " + e.getMessage());
        }
    }
}
