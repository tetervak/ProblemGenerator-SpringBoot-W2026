package ca.tetervak.problemgenerator.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class Error404Handler {

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // Ensures 404 statuses are set
    public Object handleNoResourceFoundException(NoResourceFoundException ex) {
        String path = ex.getResourcePath();
        System.out.println(path);
        if (path.startsWith("api/") || path.equals("api")) {
            // return JSON for API requests
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new ApiError(
                                    HttpStatus.NOT_FOUND.value(),
                                    ex.getClass().getSimpleName(),
                                    ex.getMessage()
                            )
                    );
        } else {
            // return HTML for non-API requests
            ModelAndView mav = new ModelAndView("error/error-404");
            mav.addObject("method", ex.getHttpMethod());
            mav.addObject("path", path);
            return mav;
        }
    }
}
