package DemoNetworking;

import java.net.URL;
import  java.net.URLConnection;
import  java.net.MalformedURLException;
import java.io.IOException;

public class DemoURLConnection {
    public static void main(String []args){
        try {
            URL myURL = new URL("http://vnexpress.net/");
            URLConnection myURLConnection = myURL.openConnection();
            myURLConnection.connect();
        }
        catch (MalformedURLException e) {
            // new URL() failed
            // ...
        }
        catch (IOException e) {
            // openConnection() failed
            // ...
        }
    }
}


