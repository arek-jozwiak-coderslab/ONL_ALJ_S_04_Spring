package pl.visa.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


public class HelloWorld {
    public void hello() {
        System.out.println("Hello World !!!" + LocalDate.now());
    }
}
