package ca.tetervak.problemgenerator.domain.addition;

import static ca.tetervak.problemgenerator.domain.addition.AdditionDifficultyEstimator.*;

public class AdditionProblemCounter {

    public static int countAdditionProblems(){
        int count = 0;
        for(int firstAddend = 1; firstAddend < 100; firstAddend++){
            for(int secondAddend = 1; secondAddend < 100; secondAddend++){
                if(firstAddend + secondAddend <= 100){
                    count++;
                }
            }
        }
        return count;
    }

    public static int countBeginnerAdditionProblems(){
        int count = 0;
        for(int firstAddend = 1; firstAddend < 100; firstAddend++){
            for(int secondAddend = 1; secondAddend < 100; secondAddend++){
                if(isBeginnerAdditionLevel(firstAddend, secondAddend)){
                    count++;
                }
            }
        }
        return count;
    }

    public static int countEasyAdditionProblems(){
        int count = 0;
        for(int firstAddend = 1; firstAddend < 100; firstAddend++){
            for(int secondAddend = 1; secondAddend < 100; secondAddend++){
                if(isEasyAdditionLevel(firstAddend, secondAddend)){
                    count++;
                }
            }
        }
        return count;
    }

    public static int countIntermediateAdditionProblems(){
        int count = 0;
        for(int firstAddend = 1; firstAddend < 100; firstAddend++){
            for(int secondAddend = 1; secondAddend < 100; secondAddend++){
                if(isIntermediateAdditionLevel(firstAddend, secondAddend)){
                    count++;
                }
            }
        }
        return count;
    }

    public static int countModerateAdditionProblems(){
        int count = 0;
        for(int firstAddend = 1; firstAddend < 100; firstAddend++){
            for(int secondAddend = 1; secondAddend < 100; secondAddend++){
                if(isModerateAdditionLevel(firstAddend, secondAddend)){
                    count++;
                }
            }
        }
        return count;
    }

    public static int countAdvancedAdditionProblems(){
        int count = 0;
        for(int firstAddend = 1; firstAddend < 100; firstAddend++){
            for(int secondAddend = 1; secondAddend < 100; secondAddend++){
                if(isAdvancedAdditionLevel(firstAddend, secondAddend)){
                    count++;
                }
            }
        }
        return count;
    }

    public static int countChallengingAdditionProblems(){
        int count = 0;
        for(int firstAddend = 1; firstAddend < 100; firstAddend++){
            for(int secondAddend = 1; secondAddend < 100; secondAddend++){
                if(isChallengingAdditionLevel(firstAddend, secondAddend)){
                    count++;
                }
            }
        }
        return count;
    }
}
