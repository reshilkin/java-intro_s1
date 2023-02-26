import java.util.Scanner;
import java.util.Arrays;
public class ReverseSum2 {
    public static void main(String[] args) {
        int[][] ans = new int[1][];
        int[] curStr = new int[1];
        Scanner sc = new Scanner(System.in);
        int strCnt = 0;
        int maxLen = 0;
        while(sc.hasNextLine()) {
            strCnt++;
            if(strCnt > ans.length) {
                ans = Arrays.copyOf(ans, ans.length * 2);
            }
            String str = sc.nextLine();
            Scanner scStr = new Scanner(str);
            int strLen = 0;
            while(scStr.hasNext()) {
                strLen++;
                if(strLen > curStr.length) {
                    curStr = Arrays.copyOf(curStr, curStr.length * 2);
                }
                curStr[strLen - 1] = scStr.nextInt();
            }
            ans[strCnt - 1] = Arrays.copyOfRange(curStr, 0, strLen);
            if(maxLen < strLen) {
                maxLen = strLen;
            }
        }
        int[] verSum = new int[maxLen];
        for(int i = 0; i < strCnt; i++) {
            int horSum = 0;
            for(int j = 0; j < ans[i].length; j++) {
                verSum[j] += ans[i][j];
                horSum += verSum[j];
                System.out.print(horSum + " ");
            }
            System.out.println();
        }        
    }
}