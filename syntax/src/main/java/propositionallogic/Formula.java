package propositionallogic;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import java.util.Objects;
import java.util.Set;

@Immutable
public class Formula {
    private final String root;
    private final Formula first;
    private final Formula second;

    public Formula(String root, @Nullable Formula first, @Nullable Formula second) {
        this.root = Objects.requireNonNull(root);
        if (SyntaxUtils.isVariable(root) || SyntaxUtils.isConstant(root)) {
            this.first = null;
            this.second = null;
        } else if (SyntaxUtils.isUnary(root)) {
            this.first = Objects.requireNonNull(first);
            this.second = null;
        } else if (SyntaxUtils.isBinary(root)) {
            this.first = Objects.requireNonNull(first);
            this.second = Objects.requireNonNull(second);
        } else {
            throw new AssertionError("Invalid root passed");
        }
    }

    public static Set<String> getAllVariables() {
        return Set.of();
    }

    public static Set<String> getAllOperators() {
        return Set.of();
    }

    @Override
    public String toString() {
        if (first == null && second == null) {
            return root;
        }
        if (second == null) {
            return root.concat(first.toString());
        }
        assert first != null;
        return "(".concat(first.toString())
                .concat(root)
                .concat(second.toString()).concat(")");
    }
}