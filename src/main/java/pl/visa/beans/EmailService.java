package pl.visa.beans;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements NotificationService {
    public void send(){
        System.out.println("Sending email");
    }
}
