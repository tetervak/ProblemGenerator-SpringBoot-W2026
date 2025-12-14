package ca.tetervak.problemgenerator.config;

import org.jspecify.annotations.NonNull;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Configuration
public class ProblemGeneratorMvcConfig implements WebMvcConfigurer {

    private final MessageSource messageSource;

    ProblemGeneratorMvcConfig(
            @NonNull MessageSource messageSource
    ){
        this.messageSource = messageSource;
    }

    // 1. Determine the locale
    @Bean
    public LocaleResolver localeResolver() {
        // 1. Get supported locales from messages.properties
        String supportedStr = messageSource.getMessage("supported.locales", null, Locale.ENGLISH);
        List<Locale> supportedLocales = Arrays.stream(supportedStr.split(","))
                .map(Locale::of)
                .collect(Collectors.toList());

        // 2. Create and configure the resolver
        SmartLocaleResolver resolver = new SmartLocaleResolver(
                "user-lang"
        );
        resolver.setCookieMaxAge(Duration.ofDays(365));
        resolver.setSupportedLocales(supportedLocales);

        // 3. Set the default locale if the list is not empty
        if (!supportedLocales.isEmpty()) {
            resolver.setDefaultLocale(supportedLocales.getFirst());
        }

        return resolver;
    }

    // 2. Allow switching locale via a URL parameter (e.g., "?lang=fr")
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang"); // Look for "?lang=" in the URL
        return lci;
    }

    // 3. Register the interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
