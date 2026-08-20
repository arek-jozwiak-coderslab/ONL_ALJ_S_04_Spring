package pl.visa;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@RestController
@RequestMapping("/hello")
public class HelloConfroller {

    private static final Logger logger
            = LoggerFactory.getLogger(HelloConfroller.class);

    @GetMapping("/")

    public String hello() {
        return "hello";
    }

    @GetMapping("/ok")

    public String ok(HttpServletRequest request, @RequestParam int age) {
        Cookie c = WebUtils.getCookie(request, "cookie2");

        int newAge = age + 12;
        request.getHeader("aasdasd");
        logger.debug("newAge:  {} ", newAge);

        return "ok";
    }
}
