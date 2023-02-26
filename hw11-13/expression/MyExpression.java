package expression;

public interface MyExpression extends Expression, TripleExpression, BigDecimalExpression, ToMiniString {
    int getPriority();

    void toMiniString(StringBuilder res, int topPriority);

    void toString(StringBuilder res);

    @Override
    String toString();
}
