package URL;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class URLReader {
    public static void main(String[] args) throws Exception {

        URL url = new URL("https://docs.oracle.com/javase/7/docs/api/java/io/FileWriter.html");
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(url.openStream())));
        while (sc.hasNext()){
            System.out.println(sc.nextLine());
        }
        sc.close();
    }
}

