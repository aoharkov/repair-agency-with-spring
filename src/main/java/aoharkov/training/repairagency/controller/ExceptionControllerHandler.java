package aoharkov.training.repairagency.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionControllerHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionControllerHandler.class);

    @ExceptionHandler(Throwable.class)
    public String exception(HttpServletRequest req, Throwable e) {
        StringBuffer requestUrl = req.getRequestURL();
        LOGGER.error("Request: {} raised {}", requestUrl, e);
        return "error500.html";
    }
}
