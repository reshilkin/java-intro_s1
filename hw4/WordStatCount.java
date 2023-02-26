import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
public class WordStatCount {
    public static void inputProc(Scanner sc, BufferedWriter writer) throws IOException {
        HashMap<String, Integer> positions = new HashMap<>();
        HashMap<Integer, Integer> wordsCount = new HashMap<>();
        LinkedList<String> words = new LinkedList<>();
        while(sc.hasNextWord()) {
            if(sc.isNextLine()) {
                continue;
            }
            String str = sc.nextWord();
            str = str.toLowerCase();
            if(positions.containsKey(str)) {
                wordsCount.put(positions.get(str), wordsCount.get(positions.get(str)) + 1);
            } else {
                wordsCount.put(words.size(), 1);
                positions.put(str, words.size());
            }
            words.add(str);
        }
        int[] ans = new int[wordsCount.size()];
        int last = 0;
        for(Integer pos : wordsCount.keySet()) {
            ans[last] = pos + wordsCount.get(pos) * words.size();
            last++;
        }
        Arrays.sort(ans);
        for(int i = 0; i < ans.length; i++) {
            writer.write(words.get(ans[i] % words.size()) + " " + ans[i] / words.size() + "\n");
        }

    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(args[0], StandardCharsets.UTF_8);
            try {
                BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8)
                );
                try {
                    inputProc(sc, writer);
                } finally {
                    writer.close();
                }
            } finally {
                sc.close();
            }  
        } catch (IOException e) {
            System.out.println("IOException! " + e.getMessage());
        }
    }
}