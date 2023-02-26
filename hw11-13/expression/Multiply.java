package expression;

import java.math.BigDecimal;

public class Multiply extends BinOp {
    public Multiply(MyExpression left, MyExpression right) {
        super(left, right);
    }

    @Override
    String getOp() {
        return "*";
    }

    @Override
    BigDecimal makeOperation(BigDecimal x, BigDecimal y) {
        return x.multiply(y);
    }

    @Override
    int makeOperation(int x, int y) {
        return x * y;
    }

    @Override
    int getLeftPriority() {
        return 49;
    }

    @Override
    int getRightPriority() {
        return 50;
    }

    @Override
    public int getPriority() {
        return 50;
    }
}
