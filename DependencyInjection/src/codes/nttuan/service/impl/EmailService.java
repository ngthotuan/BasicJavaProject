package codes.nttuan.service.impl;

import codes.nttuan.service.MessageService;

public class EmailService implements MessageService {
    @Override
    public void sendMessage(String mess, String rec) {
        System.out.printf("Email sent to %s with message: %s%n", rec, mess);
    }
}
