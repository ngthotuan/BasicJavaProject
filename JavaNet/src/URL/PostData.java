package URL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import org.json.*;

public class PostData {
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("https://nttuan-mynote.herokuapp.com/api/note");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            //connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            OutputStreamWriter out = new OutputStreamWriter(
                    connection.getOutputStream());
            out.write("{\"text\":\"test\"}");
            out.close();

            Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(connection.getInputStream())));
            while (sc.hasNext()){
                System.out.println(sc.nextLine());
            }

        } catch (IOException e) {
            System.err.println("Can't connect to " + url.getHost());
            System.err.println(e.getMessage());
        }
    }
}
