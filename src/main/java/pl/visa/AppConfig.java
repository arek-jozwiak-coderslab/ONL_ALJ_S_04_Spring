package pl.visa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.visa.beans.HelloWorld;

@Configuration
@ComponentScan
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }
}