package calculator;

import java.util.ArrayList;
import java.util.List;

public enum Operators {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    MOD("%"),
    SQUARE_ROOT("√"),
    CUBED_ROOT("∛"),
    CIRCLE_AREA("πr2"),
    ANY("ANY");

    private final String operator;

    Operators(String operator) {
        this.operator = operator;
    }

    public static List<String> getOperators() {
        List<String> operators = new ArrayList<>();
        for (Operators operator : values()) {
            operators.add(operator.asString());
        }
        return operators;
    }

    public String asString() {
        return this.operator;
    }

    public static List<String> twoWayOperators() {
        return List.of(
                Operators.PLUS.asString(),
                Operators.MINUS.asString(),
                Operators.MULTIPLY.asString(),
                Operators.DIVIDE.asString(),
                Operators.MOD.asString()
        );
    }

    public static List<String> oneWayOperators() {
        return List.of(
                Operators.SQUARE_ROOT.asString(),
                Operators.CUBED_ROOT.asString(),
                Operators.CIRCLE_AREA.asString(),
                Operators.ANY.asString()
        );
    }
}