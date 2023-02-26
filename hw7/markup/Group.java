package markup;

import java.util.List;

abstract class Group implements Element {
    final protected List<? extends Element> elements;

    protected Group(List<? extends Element> elements) {
        this.elements = elements;
    }

    protected void toMarkdown(StringBuilder sb, String edge) {
        sb.append(edge);
        for(Element element : elements) {
            element.toMarkdown(sb);
        }
        sb.append(edge);
    }

    protected void toHtml(StringBuilder sb, String edge) {
        if(edge != "") {
            sb.append("<").append(edge).append(">");
        }
        for (Element element : elements) {
            element.toHtml(sb);
        }
        if(edge != "") {
            sb.append("</").append(edge).append(">");
        }
    }
}