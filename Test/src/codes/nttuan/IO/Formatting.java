package codes.nttuan.IO;

import java.util.Locale;

public class Formatting {
    public static void main(String[] args) {
        System.out.format(Locale.US,"%(,f$", 234234.3);
    }
}
