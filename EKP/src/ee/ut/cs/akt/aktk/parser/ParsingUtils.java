package ee.ut.cs.akt.aktk.parser;


import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import ee.ut.cs.akt.aktk.ast.AstNode;

public class ParsingUtils {
	static public AstNode createAst(String program) {
		ParseTree tree = createParseTree(program);
		EKPVisitor<AstNode> visitor = new AstCreationVisitor();
		return tree.accept(visitor);
	}
	
	
	public static ParseTree createParseTree(String program) {
		ANTLRInputStream antlrInput = new ANTLRInputStream(program);
		EKPLexer lexer = new EKPLexer(antlrInput);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EKPParser parser = new EKPParser(tokens);
        ParseTree tree = parser.programm();
        System.out.println(tree.getText());
        return tree;
	}
	
}
