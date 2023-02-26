package markup;

import java.util.List;

public class OrderedList extends Group implements ItemContains {
    public OrderedList(List<ListItem> elements) {
        super(elements);
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        super.toMarkdown(sb, "");
    }

    @Override
    public void toHtml(StringBuilder sb) {
        super.toHtml(sb, "ol");
    }
}