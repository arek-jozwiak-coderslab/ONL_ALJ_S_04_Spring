package pl.visa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.visa.beans.HelloWorld;

@Configuration
@ComponentScan

public class AppConfigSimpe {


    @Bean
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }
}