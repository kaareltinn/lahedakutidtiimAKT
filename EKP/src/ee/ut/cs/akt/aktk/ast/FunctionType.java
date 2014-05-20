package ee.ut.cs.akt.aktk.ast;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends Type {
    private final List<SimpleType> argumentTypes;
    private final SimpleType returnType;

    public FunctionType(List<SimpleType> argumentTypes, SimpleType returnType) {
        this.argumentTypes = argumentTypes;
        this.returnType = returnType;
    }

    @Override
    public List<Object> getChildren() {
        List<Object> result = new ArrayList<Object>();
        result.addAll(this.argumentTypes);
        result.add(this.returnType);
        return result;
    }
    
    public List<SimpleType> getArgumentTypes(){
    	return argumentTypes;
    }
}
