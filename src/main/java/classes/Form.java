package classes;

import java.util.Objects;

public class Form {
    private String text;
    private String expression_type;

    public String getExpression_type() {
        return expression_type;
    }

    public void setExpression_type(String expression_type) {
        this.expression_type = expression_type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}