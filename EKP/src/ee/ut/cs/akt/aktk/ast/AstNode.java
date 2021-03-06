package ee.ut.cs.akt.aktk.ast;

import java.util.Iterator;
import java.util.List;

/**
 * AKTK abstraktse süntaksipuu tippude ülemklass.
 */
public abstract class AstNode {
	
	/**
	 * Annab kõik selle tipu struktuurielemendid, ka need,
	 * mis ei ole AstNode'id.
	 */
	public abstract List<Object> getChildren();

    private String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @Override
	public String toString() {
		StringBuilder sb = new StringBuilder(getSimpleName());
		
		sb.append("(");
		Iterator<Object> iter = this.getChildren().iterator();
		while (iter.hasNext()) {
			Object child = iter.next();
			if (child instanceof String) {
				String str = (String)child;
				sb.append("\""
		                + str.replaceAll("\"", "\\\"")
		                	 .replaceAll("\r\n", "\\r\\n")
		                	 .replaceAll("\n", "\\n")
		                	 .replaceAll("\t", "\\t")
		                + "\"");
			}
			else {
				sb.append(child);
			}
			if (iter.hasNext()) {
				sb.append(", ");
			}
		}		
		sb.append(")");
		
		return sb.toString();
	}

    /*
    protected void dotAddAttributes(StringBuilder out) {
        return;
    }

    private void dotHelper(StringBuilder out) {
        out.append(myID).append(" [label = \"").append(getSimpleName()).append("\", ");
        dotAddAttributes(out);
        out.append("]\n");
        for (Object child : getChildren()) {
            out.append(myID).append(" -> ").append(child.myID).append("\n");
            child.dotHelper(out);
        }
    }

    public String toDotString() {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph AST {\n");
        sb.append("bgcolor=transparent;\n");
        sb.append("node [style=filled, shape=circle, fixedsize=true];\n");
        dotHelper(sb);
        sb.append("}\n");
        return sb.toString();
    }
    */
	
	
	@Override
	public boolean equals(Object obj) {
		return obj.getClass().equals(this.getClass()) && 
				obj.toString().equals(this.toString());
	}
	
	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
}
