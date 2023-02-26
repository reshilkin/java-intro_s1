import java.util.Arrays;
import java.io.IOException;
public class ReverseHexAbc2 {
    public static String toStr(int a) {
        StringBuilder res = new StringBuilder();
        if(a < 0) {
            res.append('-');
            a *= -1;
        }
        String dec = Integer.toString(a);
        for(int i = 0; i < dec.length(); i++) {
            int temp = dec.charAt(i) - '0' + 'a';
            res.append((char)temp);
        }
        return new String(res);
    }
    public static void main(String[] args) throws IOException {
        int[][] ans = new int[1][];
        int[] curStr = new int[1];
        Scanner sc = new Scanner(System.in);
        int strCnt = 0;
        while(sc.hasNextInt()) {
            strCnt++;
            if(strCnt > ans.length) {
                ans = Arrays.copyOf(ans, ans.length * 2);
            }
            int strLen = 0;
            while(!sc.isNextLine() && sc.hasNextInt()) {
                strLen++;
                if(strLen > curStr.length) {
                    curStr = Arrays.copyOf(curStr, curStr.length * 2);
                }
                curStr[strLen - 1] = sc.nextInt();
            }
            ans[strCnt - 1] = Arrays.copyOfRange(curStr, 0, strLen);
            
        }
        for(int i = strCnt - 1; i >= 0; i--) {
            for(int j = ans[i].length - 1; j >= 0; j--) {
                System.out.print(toStr(ans[i][j]));
                System.out.print(" ");
            }
            System.out.println();
        }        
    }
}