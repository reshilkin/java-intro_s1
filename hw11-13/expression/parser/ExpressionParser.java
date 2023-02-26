package expression.parser;

import expression.*;

public class ExpressionParser implements Parser {
    private static final char END = '\0';
    private char ch = 0xffff;
    private StringSource source;

    @Override
    public MyExpression parse(String expression) {
        source = new StringSource(expression);
        take();
        return parseExpression();
    }

    public MyExpression parseExpression() {
        skipWhitespace();
        MyExpression first = parseSum();
        while (!test(')') && source.hasNext()) {
            if (take("<<")) {
                first = new ShiftLeft(first, parseSum());
            } else if (take(">>")) {
                if (take('>')) {
                    first = new ArithmeticShiftRight(first, parseSum());
                } else {
                    first = new ShiftRight(first, parseSum());
                }
            }
            skipWhitespace();
        }
        return first;
    }

    private MyExpression parseSum() {
        skipWhitespace();
        MyExpression first = parseTerm();
        while ((test('+') || test('-')) && source.hasNext()) {
            if (take('+')) {
                skipWhitespace();
                first = new Add(first, parseTerm());
            } else if (take('-')) {
                skipWhitespace();
                first = new Subtract(first, parseTerm());
            }
            skipWhitespace();
        }
        return first;
    }

    private MyExpression parseTerm() {
        MyExpression first = parseFactor();
        skipWhitespace();
        while ((test('*') || test('/')) && source.hasNext()) {
            if (take('*')) {
                skipWhitespace();
                first = new Multiply(first, parseFactor());
            } else if (take('/')) {
                skipWhitespace();
                first = new Divide(first, parseFactor());
            }
            skipWhitespace();
        }
        return first;
    }

    private MyExpression parseFactor() {
        if (take('(')) {
            MyExpression temp = parseExpression();
            take(')');
            return temp;
        } else if (take('x')) {
            return new Variable("x");
        } else if (take('y')) {
            return new Variable("y");
        } else if (take('z')) {
            return new Variable("z");
        } else if (take('-')) {
            if (between('0', '9')) {
                return new Const(Integer.parseInt(parseNumber('-')));
            } else {
                skipWhitespace();
                if (take('(')) {
                    MyExpression temp = new UnMinus(parseExpression());
                    take(')');
                    return temp;
                }
                return new UnMinus(parseFactor());
            }
        } else if (between('0', '9')) {
            return new Const(Integer.parseInt(parseNumber('+')));
        } else if (take("l0")) {
            skipWhitespace();
            return new Leading(parseFactor());
        } else if (take("t0")) {
            skipWhitespace();
            return new Trailing(parseFactor());
        }
        return null;
    }

    private String parseNumber(char sign) {
        StringBuilder res = new StringBuilder();
        res.append(sign);
        while (between('0', '9')) {
            res.append(take());
        }
        return res.toString();
    }

    private void skipWhitespace() {
        while (Character.isWhitespace(ch)) {
            take();
        }
    }

    private char take() {
        final char result = ch;
        ch = source.hasNext() ? source.next() : ExpressionParser.END;
        return result;
    }

    private boolean take(char expected) {
        if (test(expected)) {
            take();
            return true;
        }
        return false;
    }

    private boolean take(String expected) {
        for (char c : expected.toCharArray()) {
            if (!take(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean test(char expected) {
        return ch == expected;
    }

    private boolean between(final char from, final char to) {
        return from <= ch && ch <= to;
    }
}
