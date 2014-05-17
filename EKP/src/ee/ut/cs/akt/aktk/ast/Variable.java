package ee.ut.cs.akt.aktk.ast;

import java.util.Arrays;
import java.util.List;

/**
 * Viide muutujale.
 * 
 * Seda kasutatakse ainult avaldiste kontekstis. St. seda ei saa kasutada näiteks 
 * omistuslause vasakus pooles.
 */
public class Variable extends Expression {
	
	private final String name;
	private VariableDeclaration declaration = null;

	public Variable(String name) {
		this.name = name;
	}

	public Variable(String name, VariableDeclaration declaration) {
		this(name);
		this.declaration = declaration;
	}

	@Override
	public List<Object> getChildren() {
		return Arrays.asList((Object)name);
	}
	
	public String getName() {
		return name;
	}
	
	public VariableDeclaration getDeclaration() {
		return declaration;
	}
	
	public void setDeclaration(VariableDeclaration declaration) {
		this.declaration = declaration;
	}
}
