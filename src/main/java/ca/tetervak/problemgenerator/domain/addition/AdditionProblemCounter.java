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
                if(isBeginnerLevel(firstAddend, secondAddend)){
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
                if(isEasyLevel(firstAddend, secondAddend)){
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
                if(isIntermediateLevel(firstAddend, secondAddend)){
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
                if(isModerateLevel(firstAddend, secondAddend)){
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
                if(isAdvancedLevel(firstAddend, secondAddend)){
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
                if(isChallengingLevel(firstAddend, secondAddend)){
                    count++;
                }
            }
        }
        return count;
    }
}
