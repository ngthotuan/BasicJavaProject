package Socket.EchoByte;

import javax.sound.sampled.Port;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        int PORT = 12345;
        try {
            ServerSocket server = new ServerSocket(PORT);

            Scanner scInput = new Scanner(System.in);

            while (true){
                System.out.printf("Server is listening on port %d\n", PORT);
                Socket client = server.accept();
                System.out.printf("Accepted client port %d\n", client.getPort());
                InputStream in = client.getInputStream();
                OutputStream out = client.getOutputStream();

                byte bytes[] = new byte[1024];
                StringBuilder receive = new StringBuilder();
                try {
                    while ( in.read(bytes) >= 0){
                        receive.append(new String(bytes));
                    }
                }
                catch (SocketException e){
                    System.out.println("Client end!");
                }
                System.out.printf("Received from client %d data %s\n", client.getPort(), receive.toString());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
