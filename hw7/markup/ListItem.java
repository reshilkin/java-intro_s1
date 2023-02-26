package markup;

import java.util.List;

public class ListItem extends Group {
    public ListItem(List<ItemContains> elements) {
        super(elements);
    }

    @Override
    public void toHtml(StringBuilder sb) {
        super.toHtml(sb, "li");
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        super.toMarkdown(sb, "");
    }
}