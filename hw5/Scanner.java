import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.nio.charset.Charset;

public class Scanner {
    private final Reader reader;
    private final char[] buffer = new char[1024];
    private int cur = 0;
    private int len = 0;
    public Scanner(String string) {
        reader = new StringReader(string);
    }
    public Scanner(InputStream in) {
        reader = new InputStreamReader(in);
    }
    public Scanner(String file, Charset charset) throws IOException{
        reader = new InputStreamReader(new FileInputStream(file), charset);
    }
    private boolean readBlock() throws IOException{
        len = reader.read(buffer);
        cur = 0;
        if(len == -1) {
            return false;
        }
        return true;
    }

    public boolean hasNext(int type) throws IOException{
        //0 - Word, 1 - Integer;
        do {
            while(cur < len) {
                if(isLineSeparator(buffer[cur]) || (type == 0 && isWordSymbol(buffer[cur]) || type == 1 && isNumberSymbol(buffer[cur]))) {
                    return true;
                }
                cur++;
            }
        } while(readBlock());
        return false;
    }

    public boolean hasNextWord() throws IOException {
        return hasNext(0);
    }

    public boolean hasNextInt() throws IOException { 
        return hasNext(1);
    }

    public boolean isNextLine() throws IOException {
        do {
            while(cur < len) {
                if(isLineSeparator(buffer[cur])) { 
                    cur++;
                    return true;
                }
                if(isTokenSymbol(buffer[cur])) {
                    return false;
                }
                cur++;
            }
        } while(readBlock());
        return false;
    }
    public String next(int type) throws IOException {
        //0 - Word, 1 - Integer
        StringBuilder res = new StringBuilder();
        boolean hasStarted = false;
        do {
            int start = 0;
            while(cur < len) {
                if(!hasStarted && (type == 0 && isWordSymbol(buffer[cur]) || type == 1 && isNumberSymbol(buffer[cur]))) {
                    hasStarted = true;
                    start = cur;
                }
                if(hasStarted && (type == 0 && !isWordSymbol(buffer[cur]) || type == 1 && !isNumberSymbol(buffer[cur]))) {
                    res.append(buffer, start, cur - start);
                    return new String(res);
                }
                if(cur + 1 == len && hasStarted) {
                    res.append(buffer, start, cur - start + 1);
                }
                cur++;
            }
        } while(readBlock());
        return new String(res);
    }
    public String nextWord() throws IOException{
        return next(0);
    }
    public int nextInt() throws IOException {
        String num = next(1).toLowerCase();
        int start = 0;
        int res = 0;
        boolean isPos = true;
        if(num.startsWith("-")) {
            start++;
            isPos = false;
        }
        if(num.startsWith("0x", start)) {
        	res = Integer.parseUnsignedInt(num.substring(start + 2), 16);
        } else if(Character.getType(num.charAt(start)) == Character.DECIMAL_DIGIT_NUMBER) {
            res = Integer.parseUnsignedInt(num.substring(start), 10);
        } else {
            for(int i = start; i < num.length(); i++) {
                res *= 10;
                res += num.charAt(i) - 'a';
            }
        }
        if(isPos) {
            return res;
        } else {
            return -1 * res;
        }
    }
    public void close() throws IOException{
        reader.close();
        cur = 0;
        len = 0;
    }
    private boolean isLineSeparator(char c) {
        return c == System.lineSeparator().charAt(0);
    }
    public boolean isTokenSymbol(char c) {
        return (Character.getType(c) == Character.LOWERCASE_LETTER ||
                Character.getType(c) == Character.UPPERCASE_LETTER || 
                Character.getType(c) == Character.DASH_PUNCTUATION || 
                Character.getType(c) == Character.DECIMAL_DIGIT_NUMBER ||
                c == '\'');
    }
    public boolean isWordSymbol(char c) {
        return (Character.getType(c) == Character.LOWERCASE_LETTER ||
                Character.getType(c) == Character.UPPERCASE_LETTER ||
                Character.getType(c) == Character.DASH_PUNCTUATION ||
                c == '\'');
    }
    public boolean isNumberSymbol(char c) {
        return (Character.getType(c) == Character.DECIMAL_DIGIT_NUMBER ||
                Character.getType(c) == Character.LOWERCASE_LETTER ||
                Character.getType(c) == Character.UPPERCASE_LETTER ||
                Character.getType(c) == Character.DASH_PUNCTUATION);
    }
}