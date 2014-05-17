package ee.ut.cs.akt.aktk.ast;

import java.util.Arrays;
import java.util.List;

/**
 * Muutuja deklaratsioon
 */
public class VariableDeclaration extends Statement {
	private final String variableName;
	private final Expression initializer;
    private Type type = null;

    /**
     * @param variableName muutuja nimi.
     * @param initializer võib olla {@code null}.
     */
    public VariableDeclaration(String variableName, Expression initializer) {
        this(variableName, null, initializer);
    }

    /**
     * @param variableName muutuja nimi.
     * @param initializer võib olla {@code null}.
     */
    public VariableDeclaration(String variableName, Type type, Expression initializer) {
        this.variableName = variableName;
        this.type = type;
        this.initializer = initializer;
    }

	@Override
	public List<Object> getChildren() {
		return Arrays.asList(type ,(Object)variableName, initializer);
	}
	
	public String getVariableName() {
		return variableName;
	}
	
	/**
	 * @return Võib tagastada {@code null}.
	 */
	public Expression getInitializer() {
		return initializer;
	}

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
