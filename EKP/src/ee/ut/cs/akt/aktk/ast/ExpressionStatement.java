package ee.ut.cs.akt.aktk.ast;

import java.util.Arrays;
import java.util.List;

/**
 * Avaldislause.
 * 
 * Koosneb avaldisest, mis eeldatavasti annab väärtustamisel mingi kõrvalefekti
 * (nt. print("tere"))
 */
public class ExpressionStatement extends Statement {

	private final Expression expression;

	public ExpressionStatement(Expression expression) {
		this.expression = expression;
	}
	
	@Override
	public List<Object> getChildren() {
		return Arrays.asList((Object)this.expression);
	}
	
	public Expression getExpression() {
		return expression;
	}
}
