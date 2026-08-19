package pl.visa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.visa.beans.HelloWorld;
import pl.visa.beans.MessageSender;

public class SpringDiApplication {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        HelloWorld bean = context.getBean(HelloWorld.class);
        bean.hello();


        MessageSender bean1 = context.getBean(MessageSender.class);
        bean1.doingSomeStuff();
//
//        HelloWorld bean = context.getBean(HelloWorld.class);
//        bean.hello();

    }
}
