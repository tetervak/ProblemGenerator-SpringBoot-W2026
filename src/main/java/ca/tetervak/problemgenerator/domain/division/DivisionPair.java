package ca.tetervak.problemgenerator.domain.division;

public record DivisionPair(int dividend, int divisor) {

    // explicit canonical constructor with validation
    public DivisionPair {
        if (dividend < 1 || dividend > 100){
            throw new IllegalArgumentException(
                    "Dividend must be between 1 and 100: " + dividend
            );
        }
        if (divisor < 1 || divisor > 100){
            throw new IllegalArgumentException(
                    "Divisor must be between 1 and 100: " + divisor
            );
        }
        if (dividend % divisor != 0){
            throw new IllegalArgumentException(
                    "Dividend must be divisible by divisor: %d / %d"
                            .formatted(dividend, divisor)
            );
        }
    }

    public int quotient() {
        return dividend / divisor;
    }

    public String text() {
        return "%d / %d = %d".formatted(dividend, divisor, quotient());
    }
}
