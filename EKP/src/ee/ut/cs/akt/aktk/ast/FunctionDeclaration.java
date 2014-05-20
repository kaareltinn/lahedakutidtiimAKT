package ee.ut.cs.akt.aktk.ast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Funktsiooni deklareerimine.
 * 
 * Avaldise '2 + 3' AST oleks 
 * {@code new FunctionDeclaration(Sõne, "funnimi", new IntegerLiteral(2), new IntegerLiteral(3))}
 */
public class FunctionDeclaration extends Expression {

	private final String functionName;
    private final SimpleType type;
    private final List<VariableDeclaration> arguments;
    private final Statement keha;
    private final Expression tagastus;


    public FunctionDeclaration(SimpleType tyyp, String functionName, List<VariableDeclaration> arguments, Statement keha, Expression tagastus) {
		this.functionName = functionName;
		this.arguments = arguments;
        this.type = tyyp;
        this.keha = keha;
        this.tagastus = tagastus;
	}

	@Override
	public List<Object> getChildren() {
		List<Object> result = new ArrayList<Object>();
        result.add(this.type);
		result.add(this.functionName);
		result.addAll(this.arguments);
        result.add(keha);
        result.add(tagastus);
		return result;
	}
	
	public String getFunctionName() {
		return functionName;
	}
	
	public SimpleType getFunctionReturnType(){
		return type;
	}
	
	public Statement getFunctionStatment(){
		return keha;
	}
	
	public Expression getFunctionReturnExpression(){
		return tagastus;
	}
	
	public List<VariableDeclaration> getArguments() {
		return Collections.unmodifiableList(arguments);
	}
}
