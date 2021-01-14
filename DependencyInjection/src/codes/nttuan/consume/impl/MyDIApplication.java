package codes.nttuan.consume.impl;

import codes.nttuan.consume.Consumer;
import codes.nttuan.service.MessageService;

public class MyDIApplication implements Consumer {
    private MessageService messageService;

    public MyDIApplication(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void processMessage(String mess, String rec) {
        this.messageService.sendMessage(mess, rec);
    }
}
