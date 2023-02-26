import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Formatter;

public class WsppSortedSecondG {
    private static Map<String, IntList> wordsPositions;

    public static void inputProcessing(Scanner sc, BufferedWriter out) throws IOException {
        Map<String, IntListSorted> wordsPositions = new HashMap<>();
        int cnt = 0, cntStr = 0;
        while (sc.hasNextWord()) {
            if (sc.isNextLine()) {
                cntStr++;
                continue;
            }
            cnt++;
            String str = sc.nextWord().toLowerCase();
            IntListSorted temp = wordsPositions.getOrDefault(str, new IntListSorted());
            if (temp.getLength() == 0) {
                wordsPositions.put(str, temp);
            }
            temp.add(cnt, cntStr);
        }
        String[] words = new String[wordsPositions.size()];
        int last = 0;
        for (String str : wordsPositions.keySet()) {
            words[last] = str;
            last++;
        }
        Arrays.sort(words);
        for (String str : words) {
            out.write(new Formatter().format("%s %s%n", str, wordsPositions.get(str)).toString());
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(args[0], StandardCharsets.UTF_8);
            try {
                BufferedWriter out =
                        new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8));
                try {
                    inputProcessing(in, out);
                } finally {
                    out.close();
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            System.out.println("IOException!");
        }
    }
}