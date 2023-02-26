package markup;

public class Text implements ParagraphContains {
    String str;

    public Text(String str) {
        this.str = str;
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        sb.append(str);
    }

    @Override
    public void toHtml(StringBuilder sb) {
        sb.append(str);
    }
}