package pl.visa;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    public String ok() {
        logger.debug("asdasdas {} ", "aaa");
        return "ok";
    }
}
