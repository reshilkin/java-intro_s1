package expression;

import java.math.BigDecimal;

public class UnMinus extends UnOp {
    public UnMinus(MyExpression expression) {
        super(expression);
    }

    @Override
    public BigDecimal evaluate(BigDecimal x) {
        return expression.evaluate(x).negate();
    }

    @Override
    public int evaluate(int x) {
        return -expression.evaluate(x);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return -expression.evaluate(x, y, z);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        toString(res);
        return res.toString();
    }

    @Override
    public void toString(StringBuilder res) {
        res.append("-(");
        expression.toString(res);
        res.append(")");
    }

    @Override
    public String toMiniString() {
        StringBuilder res = new StringBuilder();
        toMiniString(res, getPriority());
        return res.toString();
    }

    @Override
    public void toMiniString(StringBuilder res, int topPriority) {
        res.append("-");
        if(getPriority() <= expression.getPriority()) {
            res.append(' ');
        }
        expression.toMiniString(res, getPriority());
    }

    @Override
    public int getPriority() {
        return 60;
    }
}
