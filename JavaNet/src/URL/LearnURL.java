package URL;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
// https://docs.oracle.com/javase/tutorial/networking/urls/index.html
public class LearnURL {
    private static void showInfo(URL url){
        System.out.println("url.getAuthority() = " + url.getAuthority());
        try {
            System.out.println("url.getContent() = " + url.getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("url.getDefaultPort() = " + url.getDefaultPort());
        System.out.println("url.getFile() = " + url.getFile());
        System.out.println("url.getHost() = " + url.getHost());
        System.out.println("url.getPath() = " + url.getPath());
        System.out.println("url.getPort() = " + url.getPort());
        System.out.println("url.getQuery() = " + url.getQuery());
        System.out.println("url.getRef() = " + url.getRef());
        System.out.println("url.getUserInfo() = " + url.getUserInfo());
        System.out.println("url.toExternalForm() = " + url.toExternalForm());
        try {
            System.out.println("url.toURI() = " + url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            URL aURL = new URL("http://example.com:80/docs/books/tutorial/index.html?name=networking#DOWNLOADING");
            showInfo(aURL);
        } catch (MalformedURLException mue){
            mue.printStackTrace();
        }
    }
}
