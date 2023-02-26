package markup;

import java.util.List;

public class Emphasis extends Group implements ParagraphContains {
    public Emphasis(List<ParagraphContains> elements) {
        super(elements);
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        super.toMarkdown(sb, "*");
    }

    @Override
    public void toHtml(StringBuilder sb) {
        super.toHtml(sb, "em");
    }
}