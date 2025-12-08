package ca.tetervak.problemgenerator;

import ca.tetervak.problemgenerator.domain.AlgebraProblemListFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProblemGeneratorConfiguration {

    @Bean
    AlgebraProblemListFactory algebraProblemListFactory() {
        return new AlgebraProblemListFactory();
    }
}
