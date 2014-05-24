package ee.ut.cs.akt.aktk.ast;

import java.util.Arrays;
import java.util.List;

/** 
 * Omistamine
 */
public class Assignment extends Statement {
	
	private final String variableName;
	private final Expression expression;

	public Assignment(String variableName, Expression expression) {
		this.variableName = variableName;
		this.expression = expression;
	}

	@Override
	public List<Object> getChildren() {
		return Arrays.asList((Object)variableName, expression);
	}
	
	public Expression getExpression() {
		return expression;
	}

	public String getVariableName() {
		return variableName;
	}
}
