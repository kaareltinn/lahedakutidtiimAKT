import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import ee.ut.cs.akt.aktk.ast.AstNode;
import ee.ut.cs.akt.aktk.checker.StaticChecker;
import ee.ut.cs.akt.aktk.library.Builtins;
import ee.ut.cs.akt.aktk.parser.ParsingUtils;


public class Test {

	public static void main(String[] args) throws IOException {

		AstNode ast = ParsingUtils.createAst(getProgramText("test.ekp"));
        System.out.println(ast);
        StaticChecker.check(ast);
	}
	
	private static String getProgramText(String filename) throws FileNotFoundException {
		try (Scanner sc = new Scanner(new File("test.ekp"))) {
			sc.useDelimiter("^");
			return sc.next();
		}
	}

}
