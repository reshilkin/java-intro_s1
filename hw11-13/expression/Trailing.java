package expression;

import java.math.BigDecimal;

public class Trailing extends UnOp {
    public Trailing(MyExpression expression) {
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
        res.append("t0");
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
        res.append("t0(");
        expression.toString(res);
        res.append(")");
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return countAns(expression.evaluate(x, y, z));
    }

    private int countAns(int x) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((x & 1) == 1) {
                break;
            }
            x >>>= 1;
            ans++;
        }
        return ans;
    }
}
