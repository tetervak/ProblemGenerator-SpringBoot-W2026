package ca.tetervak.problemgenerator.domain.addition;

public record AdditionPair(int firstAddend, int secondAddend) {

    // explicit canonical constructor with validation
    public AdditionPair {
        if (firstAddend < 1 || firstAddend > 99) {
            throw new IllegalArgumentException(
                    "First addend must be between 1 and 99: " + firstAddend
            );
        }
        if (secondAddend < 1 || secondAddend > 99) {
            throw new IllegalArgumentException(
                    "Second addend must be between 1 and 99: " + secondAddend
            );
        }
        if (firstAddend + secondAddend > 100) {
            throw new IllegalArgumentException(
                    "Sum of addends must be less than or equal to 100: %d + %d = %d"
                            .formatted(firstAddend, secondAddend, firstAddend + secondAddend)
            );
        }
    }

    public int sum() {
        return firstAddend + secondAddend;
    }

    public String text() {
        return "%d + %d = %d".formatted(firstAddend, secondAddend, sum());
    }
}
