package calculator;

import java.util.ArrayList;
import java.util.List;

public enum Operators {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    SQUARE_ROOT("√"),
    CUBED_ROOT("∛"),
    CIRCLE_AREA("πr2");

    private final String operator;

    Operators(String operator) {
        this.operator = operator;
    }

    public static List<String> getOperators() {
        List<String> operators = new ArrayList<>();
        for (Operators operator : values()) {
            operators.add(operator.getStringOperator());
        }
        return operators;
    }

    public String getStringOperator() {
        return this.operator;
    }

    public static List<String> twoWayOperators() {
        return List.of(
                Operators.PLUS.getStringOperator(),
                Operators.MINUS.getStringOperator(),
                Operators.MULTIPLY.getStringOperator(),
                Operators.DIVIDE.getStringOperator()
        );
    }

    public static List<String> oneWayOperators() {
        return List.of(
                Operators.SQUARE_ROOT.getStringOperator(),
                Operators.CUBED_ROOT.getStringOperator(),
                Operators.CIRCLE_AREA.getStringOperator()
        );
    }
}