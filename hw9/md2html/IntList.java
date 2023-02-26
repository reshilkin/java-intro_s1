package md2html;

import java.util.Arrays;

public class IntList {
    private int[] list;
    private int last;

    public IntList() {
        list = new int[1];
        last = 0;
    }

    public void add(int x) {
        if (last == list.length) {
            list = Arrays.copyOf(list, last * 2);
        }
        list[last++] = x;
    }

    public int get(int u) {
        return list[u];
    }

    public void sort() {
        Arrays.sort(list, 0, last);
    }

    public int getSize() {
        return last;
    }
}
