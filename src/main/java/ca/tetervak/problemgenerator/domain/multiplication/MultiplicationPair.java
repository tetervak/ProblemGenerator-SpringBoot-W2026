package ca.tetervak.problemgenerator.domain.multiplication;

import org.jspecify.annotations.NonNull;

public record MultiplicationPair(int multiplicand, int multiplier) {

    // explicit canonical constructor with validation
    public MultiplicationPair {
        if (multiplicand < 1 || multiplicand > 100) {
            throw new IllegalArgumentException("Multiplicand must be between 1 and 100");
        }
        if (multiplier < 1 || multiplier > 100) {
            throw new IllegalArgumentException("Multiplier must be between 1 and 100");
        }
        if (multiplicand * multiplier > 100) {
            throw new IllegalArgumentException(
                    "Product of multiplicand and multiplier must be less than or equal to 100");
        }
    }

    public int product() {
        return multiplicand * multiplier;
    }

    @NonNull
    public String text(){
        return multiplicand + " * " + multiplier + " = " + product();
    }
}
