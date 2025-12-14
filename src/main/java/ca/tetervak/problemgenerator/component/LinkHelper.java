package ca.tetervak.problemgenerator.component;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component("linkHelper") // Naming it so we can use it in Thymeleaf
public class LinkHelper {

    /**
     * Takes the current URL (including all parameters like ?q=laptop&page=2),
     * replaces (or adds) the 'lang' parameter, and returns the full string.
     */
    public String withLang(String langCode) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .replaceQueryParam("lang", langCode)
                .build()
                .toUriString();
    }
}
