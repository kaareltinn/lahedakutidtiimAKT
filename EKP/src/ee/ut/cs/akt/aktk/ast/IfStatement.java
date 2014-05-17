package ee.ut.cs.akt.aktk.ast;

import java.util.Arrays;
import java.util.List;

/**
 * If-lause
 */
public class IfStatement extends Statement {
	
	private final Expression condition;
	private final Statement thenBranch;
	private final Statement elseBranch;

	public IfStatement(Expression condition, Statement thenBranch, Statement elseBranch) {
		this.condition = condition;
		this.thenBranch = thenBranch;
		this.elseBranch = elseBranch;
	}

	@Override
	public List<Object> getChildren() {
		return Arrays.asList((Object)condition, thenBranch, elseBranch);
	}
	
	public Expression getCondition() {
		return condition;
	}
	
	public Statement getThenBranch() {
		return thenBranch;
	}
	
	public Statement getElseBranch() {
		return elseBranch;
	}
}
