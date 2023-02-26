package expression;

public abstract class UnOp implements MyExpression {
    protected final MyExpression expression;

    public UnOp(MyExpression expression) {
        this.expression = expression;
    }
}
