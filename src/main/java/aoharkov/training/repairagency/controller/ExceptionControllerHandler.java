package aoharkov.training.repairagency.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@ControllerAdvice
public class ExceptionControllerHandler {

    @ExceptionHandler(Throwable.class)
    public String exception(HttpServletRequest req, Throwable e) {
        StringBuffer requestUrl = req.getRequestURL();
        log.error("Request: {} raised {}", requestUrl, e);
        return "error500";
    }
}
