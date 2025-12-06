package ca.tetervak.problemgenerator.domain.subtraction;

public record SubtractionPair(int minuend, int subtrahend) {

    // explicit canonical constructor with validation
    public SubtractionPair {
        if (minuend < 2 || minuend > 100) {
            throw new IllegalArgumentException(
                    "Minuend must be between 2 and 100: " + minuend
            );
        }
        if (subtrahend < 1 || subtrahend > 99) {
            throw new IllegalArgumentException(
                    "Subtrahend must be between 1 and 99: " + subtrahend
            );
        }
        if (minuend - subtrahend < 1) {
            throw new IllegalArgumentException(
                    "Minuend must be larger than subtrahend: %d - %d"
                            .formatted(minuend, subtrahend)
            );
        }
    }

    public int difference() {
        return minuend - subtrahend;
    }

    public String text() {
        return "%d - %d = %d".formatted(minuend, subtrahend, difference());
    }
}
