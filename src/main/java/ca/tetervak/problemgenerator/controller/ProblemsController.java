package ca.tetervak.problemgenerator.controller;

import ca.tetervak.problemgenerator.domain.AlgebraProblem;
import ca.tetervak.problemgenerator.domain.AlgebraProblemCategory;
import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import ca.tetervak.problemgenerator.service.ProblemListGeneratorService;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/problems")
public class ProblemsController {


    private final ProblemListGeneratorService problemListGeneratorService;

    ProblemsController(
            @NonNull ProblemListGeneratorService problemListGeneratorService
    ){
        this.problemListGeneratorService = problemListGeneratorService;
    }

    @GetMapping({"", "/"})
    public String problemsIndex() {
        return "problems/problems-index";
    }

    @GetMapping("/form")
    public String problemRequestForm() {
        return "problems/form/form-index";
    }

    @GetMapping("/categories")
    public String problemsCategories() {
        return "problems/categories/categories-index";
    }

    @GetMapping("/categories/{category}")
    public ModelAndView problemsSpecificCategory(
            @PathVariable String category
    ) {
        ModelAndView mav = new ModelAndView("problems/categories/specific-category");
        mav.addObject("category", category);
        String[] levels = {"beginner", "easy", "intermediate", "moderate", "advanced", "challenging"};
        mav.addObject("levels", levels);
        return mav;
    }

    @GetMapping("/generator")
    public ModelAndView problemsGenerator(
            @RequestParam(defaultValue = "addition") String category,
            @RequestParam(defaultValue = "beginner") String level,
            @RequestParam(defaultValue = "5") int number
    ) {
        ModelAndView mav = new ModelAndView("problems/generator/generated-problems");
        mav.addObject("category", category);
        mav.addObject("level", level);
        List<AlgebraProblem> list = problemListGeneratorService
                .createRandomAlgebraProblemList(
                        AlgebraProblemCategory.fromString(category),
                        DifficultyLevel.fromString(level),
                        number
                );

        mav.addObject("problems", list);
        return mav;
    }

    @ModelAttribute("categories")
    public String[] getCategories() {
        return new String[]{"addition", "subtraction", "multiplication", "division"};
    }
}
