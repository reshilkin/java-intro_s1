package expression;

import java.math.BigDecimal;

public class ShiftRight extends BinOp {
    public ShiftRight(MyExpression left, MyExpression right) {
        super(left, right);
    }

    @Override
    protected String getOp() {
        return ">>";
    }

    @Override
    BigDecimal makeOperation(BigDecimal x, BigDecimal y) {
        return null;
    }

    @Override
    int makeOperation(int x, int y) {
        return x >> y;
    }

    @Override
    int getLeftPriority() {
        return 10;
    }

    @Override
    int getRightPriority() {
        return 11;
    }

    @Override
    public int getPriority() {
        return 10;
    }
}
