import java.math.BigInteger;
public class SumBigIntegerHex {
    public static BigInteger getComponent(String input, int begin, int end) {
        String number = input.substring(begin, end);
        if(number.contains("0x") || number.contains("0X")) {
            return new BigInteger(number.substring(2, number.length()), 16);
        } else {
            return new BigInteger(number);
        }
    }
    public static void main(String[] args) {
        BigInteger result = BigInteger.valueOf(0);
        for(int i = 0; i < args.length; i++) {
           int begin = 0;
            for(int end = 0; end < args[i].length(); end++) {
                if(Character.isWhitespace(args[i].charAt(end))) {
                    if(begin < end) {
                        result = result.add(getComponent(args[i], begin, end));
                    }
                    begin = end + 1;
                }
            }
            if(begin < args[i].length()) {
                result = result.add(getComponent(args[i], begin, args[i].length()));
            }
        }
        System.out.println(result.toString());
    }
}
