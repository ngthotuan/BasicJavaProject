package Socket.EchoByte;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
//    private static byte[] readClientInput(){
//        byte[] bytes = null;
//        try {
//            bytes = System.in.readAllBytes();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return bytes;
//    }
    public static void main(String[] args) {
        Socket client = null;
        try {
            client = new Socket("127.0.0.1", 12345);
            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();

            System.out.print("type a message: ");
            String str = new Scanner(System.in).nextLine();
            out.write(str.getBytes());
            System.out.println("sent");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
