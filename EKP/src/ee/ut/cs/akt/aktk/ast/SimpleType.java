package ee.ut.cs.akt.aktk.ast;

import java.util.Arrays;
import java.util.List;

public class SimpleType extends Type {
    private final String name;

    public SimpleType(String name) {
        this.name = name;
    }

    @Override
    public List<Object> getChildren() {
        return Arrays.asList((Object) name);
    }

    public String getName() {
        return name;
    }
}
