package expression;


import java.math.BigDecimal;

public abstract class BinOp implements MyExpression {
    protected final MyExpression left;
    protected final MyExpression right;

    protected BinOp(MyExpression left, MyExpression right) {
        this.left = left;
        this.right = right;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        toString(res);
        return res.toString();
    }

    public void toString(StringBuilder res) {
        res.append('(');
        left.toString(res);
        res.append(' ').append(this.getOp()).append(' ');
        right.toString(res);
        res.append(')');
    }

    abstract String getOp();

    public int hashCode() {
        return (left.hashCode() * 17 + right.hashCode()) * 17 + getOp().hashCode();
    }

    @Override
    public boolean equals(final Object object) {
        if (object != null && object.getClass().equals(this.getClass())) {
            return this.left.equals(((BinOp) object).left) && this.right.equals(((BinOp) object).right);
        }
        return false;
    }

    @Override
    public String toMiniString() {
        StringBuilder res = new StringBuilder();
        toMiniString(res, -1);
        return res.toString();
    }

    @Override
    public void toMiniString(StringBuilder res, int topPriority) {
        if (topPriority > getPriority()) {
            res.append('(');
        }
        left.toMiniString(res, getLeftPriority());
        res.append(" ").append(getOp()).append(" ");
        right.toMiniString(res, getRightPriority());
        if (topPriority > getPriority()) {
            res.append(')');
        }
    }

    abstract BigDecimal makeOperation(BigDecimal x, BigDecimal y);

    abstract int makeOperation(int x, int y);

    abstract int getLeftPriority();

    abstract int getRightPriority();

    @Override
    public final BigDecimal evaluate(BigDecimal x) {
        return this.makeOperation(left.evaluate(x), right.evaluate(x));
    }

    @Override
    public final int evaluate(int x) {
        return this.makeOperation(left.evaluate(x), right.evaluate(x));
    }

    @Override
    public final int evaluate(int x, int y, int z) {
        return this.makeOperation(left.evaluate(x, y, z), right.evaluate(x, y, z));
    }
}
