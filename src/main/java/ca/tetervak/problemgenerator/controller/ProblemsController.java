package ca.tetervak.problemgenerator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/problems")
public class ProblemsController {

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
        String[] levels = {"beginner", "medium", "intermediate", "moderate", "advanced", "challenging"};
        mav.addObject("levels", levels);
        return mav;
    }

    @ModelAttribute("categories")
    public String[] getCategories() {
        return new String[]{"addition", "subtraction", "multiplication", "division"};
    }
}
