package expression;

import java.math.BigDecimal;

public class Subtract extends BinOp {
    public Subtract(MyExpression left, MyExpression right) {
        super(left, right);
    }

    @Override
    String getOp() {
        return "-";
    }

    @Override
    BigDecimal makeOperation(BigDecimal x, BigDecimal y) {
        return x.subtract(y);
    }

    @Override
    int makeOperation(int x, int y) {
        return x - y;
    }

    @Override
    int getLeftPriority() {
        return 20;
    }

    @Override
    int getRightPriority() {
        return 21;
    }

    @Override
    public int getPriority() {
        return 20;
    }
}
