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
                    if (isBeginnerLevel(minuend, subtrahend)) {
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
                    if (isEasyLevel(minuend, subtrahend)) {
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
                    if (isIntermediateLevel(minuend, subtrahend)) {
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
                    if (isModerateLevel(minuend, subtrahend)) {
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
                    if (isAdvancedLevel(minuend, subtrahend)) {
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
                    if (isChallengingLevel(minuend, subtrahend)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
