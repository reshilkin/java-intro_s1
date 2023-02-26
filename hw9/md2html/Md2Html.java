package md2html;

import java.io.*;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Md2Html {
    private static final List<Separator> SEPARATORS =
            List.of(new Separator("*", "*", "em"), new Separator("_", "_", "em"), new Separator("**", "**", "strong"), new Separator("__", "__", "strong"), new Separator("`", "`", "code"), new Separator("--", "--", "s"), new Separator("<<", ">>", "ins"), new Separator("}}", "{{", "del"));
    private static final Separator NO_SEPARATOR = new Separator("", "", "");

    public static Separator nextSep(final int cur, final String block) {
        Separator res = NO_SEPARATOR;
        for (final Separator separator : SEPARATORS) {
            if (separator.startsWith(cur, block, res)) {
                res = separator;
            }
        }
        return res;
    }

    public static String blockProcessing(final String block) {
        int cur = 0;
        final IntList sepPositions = new IntList();
        final Map<Separator, Integer> last = new HashMap<>();
        while (cur < block.length()) {
            final char c = block.charAt(cur);
            if (c == '\\') {
                cur += 2;
                continue;
            }
            final Separator curSep = nextSep(cur, block);
            if (curSep.getClosing().isEmpty()) {
                cur++;
                continue;
            }
            final int prev = last.getOrDefault(curSep, -1);
            if (block.startsWith(curSep.getClosing(), cur) && prev > -1) {
                boolean correct = true;
                for (final Separator separator : SEPARATORS) {
                    if (last.getOrDefault(separator, -1) > prev) {
                        correct = false;
                    }
                }
                if (correct) {
                    sepPositions.add(prev);
                    sepPositions.add(cur);
                    cur += curSep.getClosing().length();
                    last.put(curSep, -1);
                    continue;
                }
            }
            if (block.startsWith(curSep.getOpening(), cur)) {
                last.put(curSep, cur);
            }
            cur += curSep.getClosing().length();
        }
        sepPositions.sort();
        final StringBuilder res = new StringBuilder();
        cur = 0;
        int level = 0;
        int lastSep = 0;
        last.clear();
        while (block.charAt(cur) == '#') {
            cur++;
            level++;
        }
        if (!Character.isWhitespace(block.charAt(cur))) {
            cur = 0;
            level = 0;
        } else if (level > 0) {
            cur++;
        }

        if (level == 0) {
            res.append("<p>");
        } else {
            res.append("<h").append(level).append(">");
        }
        while (cur < block.length()) {
            if (lastSep < sepPositions.getSize() && sepPositions.get(lastSep) == cur) {
                final Separator curSep = nextSep(cur, block);
                if (last.getOrDefault(curSep, -1) == -1) {
                    last.put(curSep, 1);
                    res.append("<").append(curSep.getHtmlTag()).append(">");
                    cur += curSep.getOpening().length();
                } else {
                    last.put(curSep, -1);
                    res.append("</").append(curSep.getHtmlTag()).append(">");
                    cur += curSep.getClosing().length();
                }
                lastSep++;
                continue;
            }
            switch (block.charAt(cur)) {
                case '<':
                    res.append("&lt;");
                    break;
                case '>':
                    res.append("&gt;");
                    break;
                case '&':
                    res.append("&amp;");
                    break;
                case '\\':
                    break;
                default:
                    res.append(block.charAt(cur));
            }
            cur++;
        }
        if (level == 0) {
            res.append("</p>");
        } else {
            res.append("</h").append(level).append(">");
        }
        res.append(System.lineSeparator());
        return res.toString();
    }

    public static String solve(final BufferedReader in) throws IOException {
        String str;
        final StringBuilder res = new StringBuilder();
        while (true) {
            do {
                str = in.readLine();
            } while (str != null && str.isEmpty());
            if (str == null) {
                break;
            }
            final StringBuilder block = new StringBuilder();
            while (str != null && !str.isEmpty()) {
                if (block.length() != 0) {
                    block.append(System.lineSeparator());
                }
                block.append(str);
                str = in.readLine();
            }
            res.append(blockProcessing(block.toString()));
        }
        return res.toString();
    }

    public static void main(final String[] args) {
        try {
            final BufferedReader in =
                    new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), StandardCharsets.UTF_8));
            String res;
            try {
                res = solve(in);
            } finally {
                in.close();
            }
            try (final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8))) {
                out.write(res);
            }
        } catch (final IOException e) {
            System.out.println(e.getMessage());
        }
    }
}