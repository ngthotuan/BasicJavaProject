package codes.nttuan.main;

import codes.nttuan.consume.Consumer;
import codes.nttuan.injector.MessageServiceInjector;
import codes.nttuan.injector.impl.EmailServiceInjector;
import codes.nttuan.injector.impl.SMSServiceInjector;

public class Main {
    public static void main(String[] args) {
//        reference: https://www.journaldev.com/2394/java-dependency-injection-design-pattern-example-tutorial
        String email = "nttuan@gmail.com";
        String phone = "0987654321";
        String message = "Hi Tuan, How's it going?";

        MessageServiceInjector injector = null;
        Consumer app = null;

        //send email
        injector = new EmailServiceInjector();
        app = injector.getConsumer();
        app.processMessage(message, email);

        //send SMS
        injector = new SMSServiceInjector();
        app = injector.getConsumer();
        app.processMessage(message, phone);
    }
}
