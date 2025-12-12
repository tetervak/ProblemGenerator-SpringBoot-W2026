package ca.tetervak.problemgenerator;

import ca.tetervak.problemgenerator.domain.AlgebraProblemFactory;
import ca.tetervak.problemgenerator.domain.AlgebraProblemListFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class ProblemGeneratorConfiguration {

    @Bean
    Random random() {
        return new Random();
    }

    @Bean
    AlgebraProblemFactory algebraProblemFactory() {
        return new AlgebraProblemFactory();
    }

    @Bean
    AlgebraProblemListFactory algebraProblemListFactory() {
        return new AlgebraProblemListFactory();
    }
}
