package markup;

import java.util.List;

public class UnorderedList extends Group implements ItemContains {
    public UnorderedList(List<ListItem> elements) {
        super(elements);
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        super.toMarkdown(sb, "");
    }

    @Override
    public void toHtml(StringBuilder sb) {
        super.toHtml(sb, "ul");
    }
}