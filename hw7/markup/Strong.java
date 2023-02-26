package markup;

import java.util.List;

public class Strong extends Group implements ParagraphContains {

    public Strong(List<ParagraphContains> elements) {
        super(elements);
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        super.toMarkdown(sb, "__");
    }

    @Override
    public void toHtml(StringBuilder sb) {
        super.toHtml(sb, "strong");
    }
}