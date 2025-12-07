package ca.tetervak.problemgenerator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/problem-list")
public class ProblemListController {

    @GetMapping("")
    public String getProblemCategories() {
        return "categories";
    }

    @GetMapping("/{category}")
    public ModelAndView getProblemDifficultyLevels(
            @PathVariable String category
    ) {
        ModelAndView mav = new ModelAndView("difficulties");
        mav.addObject("category", category);
        String[] levels = {"beginner", "medium", "intermediate", "moderate", "advanced", "challenging"};
        mav.addObject("levels", levels);
        return mav;
    }

    @GetMapping("/{category}/{difficulty}")
    public ModelAndView getProblemList(
            @PathVariable String category,
            @PathVariable String difficulty,
            @RequestParam(name = "number", defaultValue = "10")
            int numberOfProblems
    ) {
        ModelAndView mav = new ModelAndView("problems");
        mav.addObject("category", category);
        mav.addObject("difficulty", difficulty);
        mav.addObject("number", numberOfProblems);
        return mav;
    }
}
