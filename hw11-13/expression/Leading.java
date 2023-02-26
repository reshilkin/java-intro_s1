package expression;

import java.math.BigDecimal;

public class Leading extends UnOp {
    public Leading(MyExpression expression) {
        super(expression);
    }

    @Override
    public BigDecimal evaluate(BigDecimal x) {
        return BigDecimal.valueOf(countAns(expression.evaluate(x).intValue()));
    }

    @Override
    public int evaluate(int x) {
        return countAns(expression.evaluate(x));
    }

    @Override
    public int getPriority() {
        return 60;
    }

    @Override
    public String toMiniString() {
        StringBuilder res = new StringBuilder();
        toMiniString(res, getPriority());
        return res.toString();
    }

    @Override
    public void toMiniString(StringBuilder res, int topPriority) {
        res.append("l0");
        if (expression.getPriority() >= getPriority()) {
            res.append(" ");
        }
        expression.toMiniString(res, getPriority());
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        toString(res);
        return res.toString();
    }

    @Override
    public void toString(StringBuilder res) {
        res.append("l0(");
        expression.toString(res);
        res.append(")");
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return countAns(expression.evaluate(x, y, z));
    }

    private int countAns(int x) {
        if (x < 0) {
            return 0;
        }
        int ans = 32;
        while (x > 0) {
            ans--;
            x /= 2;
        }
        return ans;
    }
}
