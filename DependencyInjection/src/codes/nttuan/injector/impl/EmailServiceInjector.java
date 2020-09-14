package codes.nttuan.injector.impl;

import codes.nttuan.consume.Consumer;
import codes.nttuan.consume.impl.MyDIApplication;
import codes.nttuan.injector.MessageServiceInjector;
import codes.nttuan.service.impl.EmailService;

public class EmailServiceInjector implements MessageServiceInjector {
    @Override
    public Consumer getConsumer() {
        return new MyDIApplication(new EmailService());
    }
}
