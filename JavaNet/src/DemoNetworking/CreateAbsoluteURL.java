package DemoNetworking;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class CreateAbsoluteURL {

    public static void main(String[] args) {
//        try {
//            URL myURL = new URL("http://example.com/");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }

        URL myURL = null;
        URL page1URL = null;
        URL page2URL = null;
        URL page1BottomURL = null;
        try {
            myURL = new URL("http://example.com/pages/");
            page1URL = new URL(myURL, "page1.html");
            page1BottomURL = new URL(page1URL, "#BOTTOM");
            page2URL = new URL(myURL, "page2.html");
//            URL url = new URL("http://example.com/hello%20world");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        URI uri = null;
        try {
            uri = new URI("http", "example.com",
                    "/hello world/", "");
            URL url = uri.toURL();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
