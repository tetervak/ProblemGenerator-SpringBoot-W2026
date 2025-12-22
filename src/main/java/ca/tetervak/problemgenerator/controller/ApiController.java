package ca.tetervak.problemgenerator.controller;

import ca.tetervak.problemgenerator.domain.*;
import ca.tetervak.problemgenerator.model.AlgebraProblemDto;
import ca.tetervak.problemgenerator.repository.AlgebraProblemRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/problems")
@Tag(name = "Generator", description = "Generate list of problems")
public class ApiController {

    private final AlgebraProblemRepository problemRepository;

    public ApiController(AlgebraProblemRepository repository) {
        this.problemRepository = repository;
    }

    @GetMapping(value = "/generator",
            produces = "application/json")
    @Operation(summary = "Generate a list of algebra problems",
            description = "Generate a list of algebra problems based on category, level, and number of problems")
    @Parameters({
            @Parameter(
                    name = "category",
                    description = "The category of algebra problems to generate: addition, subtraction, multiplication, or division",
                    example = "multiplication"
            ),
            @Parameter(
                    name = "level",
                    description =
                            "The difficulty level of the problems: beginner, easy, intermediate, moderate, advanced, or challenging",
                    example = "moderate"
            ),
            @Parameter(
                    name = "number",
                    description = "The number of problems to generate: 1..10",
                    example = "10"
            )
    })
    public List<AlgebraProblemDto> generate(
            @RequestParam(defaultValue = "addition") String category,
            @RequestParam(defaultValue = "beginner") String level,
            @RequestParam(defaultValue = "5") int number
    ) {
        if (number < 1 || number > 10) {
            throw new IllegalArgumentException("Number must be between 1 and 10");
        }

        List<AlgebraProblem> list = problemRepository
                .getRandomAlgebraProblemList(
                        AlgebraProblemCategory.fromString(category),
                        DifficultyLevel.fromString(level),
                        number
                );

        return list.stream().map(AlgebraProblemDto::new).toList();
    }

    @GetMapping(value = "/counts", produces = "application/json")
    @Operation(summary = "Get counts of algebra problems by categories and levels")
    public CountsByCategoriesAndLevels getAlgebraProblemCounts() {
        return problemRepository.getAlgebraProblemCounts();
    }

    @GetMapping(value = "/categories/{category}/counts", produces = "application/json")
    @Operation(summary = "Get counts of algebra problems for a specific category")
    @Parameters({
            @Parameter(
                    name = "category",
                    description =
                            "The category of algebra problems: addition, subtraction, multiplication, or division",
                    example = "multiplication"
            )
    })
    public CountsByLevels getAlgebraProblemCountsForCategory(
            @PathVariable String category
    ){
        return problemRepository.getAlgebraProblemCountsByCategory(
                AlgebraProblemCategory.fromString(category)
        );
    }

}
