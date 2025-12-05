package ca.tetervak.problemgenerator.domain.subtraction;

import static ca.tetervak.problemgenerator.domain.subtraction.SubtractionDifficultyEstimator.*;

public class SubtractionProblemCounter {

    public static int countSubtractionProblems() {
        int count = 0;
        for (int minuend = 2; minuend <= 100; minuend++) {
            for (int subtrahend = 1; subtrahend <= 99; subtrahend++) {
                if (minuend > subtrahend) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countBeginnerSubtractionProblems() {
        int count = 0;
        for (int minuend = 2; minuend <= 100; minuend++) {
            for (int subtrahend = 1; subtrahend <= 99; subtrahend++) {
                if (minuend > subtrahend) {
                    if (isBeginnerSubtractionLevel(minuend, subtrahend)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int countEasySubtractionProblems() {
        int count = 0;
        for (int minuend = 2; minuend <= 100; minuend++) {
            for (int subtrahend = 1; subtrahend <= 99; subtrahend++) {
                if (minuend > subtrahend) {
                    if (isEasySubtractionLevel(minuend, subtrahend)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int countIntermediateSubtractionProblems() {
        int count = 0;
        for (int minuend = 2; minuend <= 100; minuend++) {
            for (int subtrahend = 1; subtrahend <= 99; subtrahend++) {
                if (minuend > subtrahend) {
                    if (isIntermediateSubtractionLevel(minuend, subtrahend)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int countModerateSubtractionProblems() {
        int count = 0;
        for (int minuend = 2; minuend <= 100; minuend++) {
            for (int subtrahend = 1; subtrahend <= 99; subtrahend++) {
                if (minuend > subtrahend) {
                    if (isModerateSubtractionLevel(minuend, subtrahend)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int countAdvancedSubtractionProblems() {
        int count = 0;
        for (int minuend = 2; minuend <= 100; minuend++) {
            for (int subtrahend = 1; subtrahend <= 99; subtrahend++) {
                if (minuend > subtrahend) {
                    if (isAdvancedSubtractionLevel(minuend, subtrahend)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int countChallengingSubtractionProblems() {
        int count = 0;
        for (int minuend = 2; minuend <= 100; minuend++) {
            for (int subtrahend = 1; subtrahend <= 99; subtrahend++) {
                if (minuend > subtrahend) {
                    if (isChallengingSubtractionLevel(minuend, subtrahend)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
