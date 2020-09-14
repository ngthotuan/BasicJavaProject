package codes.nttuan.injector.impl;

import codes.nttuan.consume.Consumer;
import codes.nttuan.consume.impl.MyDIApplication;
import codes.nttuan.injector.MessageServiceInjector;
import codes.nttuan.service.impl.SMSService;

public class SMSServiceInjector implements MessageServiceInjector {
    @Override
    public Consumer getConsumer() {
        return new MyDIApplication(new SMSService());
    }
}
