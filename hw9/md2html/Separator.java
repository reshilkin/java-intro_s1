package md2html;

public class Separator {
    private final String opening;
    private final String closing;
    private final String htmlTag;

    public Separator(final String opening, final String closing, final String htmlTag) {
        this.opening = opening;
        this.closing = closing;
        this.htmlTag = htmlTag;
    }

    public String getOpening() {
        return opening;
    }

    public String getClosing() {
        return closing;
    }

    public String getHtmlTag() {
        return htmlTag;
    }

    boolean startsWith(final int cur, final String block, final Separator res) {
        return block.startsWith(opening, cur) && opening.length() > res.opening.length()
                || block.startsWith(closing, cur);
    }
}
