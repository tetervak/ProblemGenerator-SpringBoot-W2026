package ca.tetervak.problemgenerator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
public class HomeController {

    @GetMapping({"/", "/index"})
    public String index() {
        return "home/home-index";
    }

    @GetMapping("/about")
    public ModelAndView about(Locale locale) {

        ModelAndView mav = new ModelAndView();
        String language = locale.getLanguage();
        switch (language) {
            case "uk" -> mav.setViewName("home/home-about_uk");
            case "ru" -> mav.setViewName("home/home-about_ru");
            default -> mav.setViewName("home/home-about");
        }

        return mav;
    }
}
