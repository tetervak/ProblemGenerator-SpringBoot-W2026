package ca.tetervak.problemgenerator.controller;

import ca.tetervak.problemgenerator.domain.AlgebraProblem;
import ca.tetervak.problemgenerator.domain.AlgebraProblemCategory;
import ca.tetervak.problemgenerator.domain.CountsByLevels;
import ca.tetervak.problemgenerator.domain.DifficultyLevel;
import ca.tetervak.problemgenerator.model.CompareForm;
import ca.tetervak.problemgenerator.model.RequestForm;
import ca.tetervak.problemgenerator.repository.AlgebraProblemRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/problems")
public class ProblemsController {

    private final AlgebraProblemRepository problemRepository;

    ProblemsController(
            @NonNull AlgebraProblemRepository problemRepository
    ){
        this.problemRepository = problemRepository;
    }

    @GetMapping({"", "/"})
    public String problemsIndex() {
        return "problems/problems-index";
    }

    @GetMapping("/form")
    public String problemRequestForm(
            @ModelAttribute RequestForm requestForm,
            Model model
    ) {
        model.addAttribute("requestForm", requestForm);
        String[] levels = {"beginner", "easy", "intermediate", "moderate", "advanced", "challenging"};
        model.addAttribute("levels", levels);
        return "problems/form/form-index";
    }

    @GetMapping("/form/confirm")
    public String problemRequestFormConfirm(
            @ModelAttribute RequestForm requestForm,
            Model model
    ) {
        model.addAttribute("requestForm", requestForm);
        return "problems/form/form-confirm";
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
        CountsByLevels countsByLevels = problemRepository.getAlgebraProblemCountsByLevels(
                AlgebraProblemCategory.fromString(category)
        );
        mav.addObject("countsByLevels", countsByLevels);
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
        List<AlgebraProblem> list = problemRepository
                .getRandomAlgebraProblemList(
                        AlgebraProblemCategory.fromString(category),
                        DifficultyLevel.fromString(level),
                        number
                );

        mav.addObject("problems", list);
        return mav;
    }

    @GetMapping("/categories/{category}/compare-levels")
    public String problemsCompareLevelsInput(
            @PathVariable String category,
            @CookieValue(name = "compare-number", required = false, defaultValue = "5") Integer number,
            @ModelAttribute CompareForm compareForm,
            Model model,
            HttpServletResponse response
    ) {
        if(compareForm.getNumber() == 0){
            compareForm.setNumber(number);
        } else {
            Cookie cookie = new Cookie(
                    "compare-number", String.valueOf(compareForm.getNumber()));
            cookie.setMaxAge(60 * 60 * 24);
            cookie.setPath("/problems/categories/");
            cookie.setHttpOnly(true);
            cookie.setAttribute("SameSite", "Strict");
            response.addCookie(cookie);
        }
        model.addAttribute("compareForm", compareForm);
        String[] levels = {"beginner", "easy", "intermediate", "moderate", "advanced", "challenging"};
        model.addAttribute("levels", levels);
        List<AlgebraProblem> firstList = problemRepository.getRandomAlgebraProblemList(
                AlgebraProblemCategory.fromString(category),
                DifficultyLevel.fromString(compareForm.getFirstLevel()),
                compareForm.getNumber()
        );
        List<AlgebraProblem> secondList = problemRepository.getRandomAlgebraProblemList(
                AlgebraProblemCategory.fromString(category),
                DifficultyLevel.fromString(compareForm.getSecondLevel()),
                compareForm.getNumber()
        );
        model.addAttribute("category", category);
        model.addAttribute("firstList", firstList);
        model.addAttribute("secondList", secondList);
        return "problems/categories/compare-levels";
    }

    @ModelAttribute("categories")
    public String[] getCategories() {
        return new String[]{"addition", "subtraction", "multiplication", "division"};
    }
}
