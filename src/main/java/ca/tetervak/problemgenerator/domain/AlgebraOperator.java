package ca.tetervak.problemgenerator.domain;

public enum AlgebraOperator {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char symbol;

    AlgebraOperator(char symbol) {
        this.symbol = symbol;
    }

    Character getSymbol(){
        return symbol;
    }

    public static AlgebraOperator fromSymbol(char symbol) {
        return switch (symbol) {
            case '+' -> ADD;
            case '-' -> SUBTRACT;
            case '*' -> MULTIPLY;
            case '/' -> DIVIDE;
            default -> throw new IllegalArgumentException("No AlgebraOperator found for symbol: " + symbol);
        };
    }

    public int calculate(int firstOperand, int secondOperand) {
        return switch (this) {
            case ADD -> firstOperand + secondOperand;
            case SUBTRACT -> firstOperand - secondOperand;
            case MULTIPLY -> firstOperand * secondOperand;
            case DIVIDE -> firstOperand / secondOperand;
        };
    }
}
