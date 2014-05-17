package ee.ut.cs.akt.aktk.ast;

import java.util.Arrays;
import java.util.List;

/** 
 * while-lause.
 */
public class WhileStatement extends Statement {
	
	private final Expression condition;
	private final Statement body;

	public WhileStatement(Expression condition, Statement body) {
		this.condition = condition;
		this.body = body;
	}

	@Override
	public List<Object> getChildren() {
		return Arrays.asList((Object)condition, body);
	}
	
	public Expression getCondition() {
		return condition;
	}
	
	public Statement getBody() {
		return body;
	}
}
