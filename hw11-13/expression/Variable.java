package expression;

import java.math.BigDecimal;
import java.util.InputMismatchException;

public class Variable implements MyExpression {
    private final String value;

    public Variable(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int evaluate(int x) {
        return x;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        if (value.equals("x")) {
            return x;
        } else if (value.equals("y")) {
            return y;
        } else if (value.equals("z")) {
            return z;
        }
        throw new InputMismatchException("Wrong Variable name. Please, use \"x\",\"y\" or \"z\"");
    }

    @Override
    public BigDecimal evaluate(BigDecimal x) {
        return x;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public void toString(StringBuilder res) {
        res.append(value);
    }

    @Override
    public String toMiniString() {
        return value;
    }

    @Override
    public void toMiniString(StringBuilder res, int topPriority) {
        res.append(value);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Variable) {
            return ((Variable) object).getValue().equals(value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public int getPriority() {
        return 60;
    }
}
