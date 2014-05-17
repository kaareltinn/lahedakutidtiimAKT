package ee.ut.cs.akt.aktk.ast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Funktsiooni väljakutse.
 * 
 * NB! Seda klassi tuleks kasutada ka infiksoperatsioonide (nt. 2 + 3) 
 * tähistamiseks (AstNode klassihierarhias ei ole infikspoeratsioonidele eraldi klassi).
 * 
 * Avaldise '2 + 3' AST oleks 
 * {@code new FunctionCall("+", new IntegerLiteral(2), new IntegerLiteral(3))}
 */
public class FunctionCall extends Expression {
	
	private final String functionName;
	private final List<Expression> arguments;

	public FunctionCall(String functionName, List<Expression> arguments) {
		this.functionName = functionName;
		this.arguments = arguments;
	}

	@Override
	public List<Object> getChildren() {
		List<Object> result = new ArrayList<Object>();
		result.add(this.functionName);
		result.addAll(this.arguments);
		return result;
	}
	
	public String getFunctionName() {
		return functionName;
	}
	
	public List<Expression> getArguments() {
		return Collections.unmodifiableList(arguments);
	}
	
	public boolean isComparisonOperation() {
		return Arrays.asList(">", "<", ">=", "<=", "==", "!=").contains(this.functionName);
	}
	
	public boolean isArithmeticOrLogicOperation() {
		return Arrays.asList("+", "-", "*", "/", "%", "&", "|", "^", "<<", ">>", ">>>").contains(this.functionName);
	}
}
