package ca.tetervak.problemgenerator.errors;

public record ApiError(
        int status,
        String error,
        String message
){}
