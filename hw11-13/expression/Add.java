package expression;

import java.math.BigDecimal;

public class Add extends BinOp {
    public Add(MyExpression left, MyExpression right) {
        super(left, right);
    }

    @Override
    protected String getOp() {
        return "+";
    }

    @Override
    BigDecimal makeOperation(BigDecimal x, BigDecimal y) {
        return x.add(y);
    }

    @Override
    int makeOperation(int x, int y) {
        return x + y;
    }

    @Override
    int getLeftPriority() {
        return 20;
    }

    @Override
    int getRightPriority() {
        return 20;
    }

    @Override
    public int getPriority() {
        return 20;
    }
}
