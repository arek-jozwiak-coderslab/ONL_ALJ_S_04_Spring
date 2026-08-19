package pl.visa.beans;

import org.springframework.stereotype.Component;

@Component
public class MessageSender {
    private NotificationService service;

    public MessageSender(NotificationService service) {
        this.service = service;
    }
    public void doingSomeStuff() {
        service.send();
    }
}
