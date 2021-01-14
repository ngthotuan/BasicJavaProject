package codes.nttuan.service.impl;

import codes.nttuan.service.MessageService;

public class SMSService implements MessageService {
    @Override
    public void sendMessage(String mess, String rec) {
        System.out.printf("SMS sent to %s with message: %s%n", rec, mess);
    }
}
