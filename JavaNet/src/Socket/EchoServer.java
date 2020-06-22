package Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    private static final int PORT = 1234;
    public static void main(String[] args) throws IOException {
        try{
            ServerSocket server = new ServerSocket(PORT);
            System.out.printf("Server is listening on port %d...%n", PORT);
            Socket client = server.accept();
            System.out.printf("Accept client port %d%n", client.getPort());

            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(client.getInputStream())));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String clientMessage = in.nextLine();
            while (!clientMessage.equalsIgnoreCase("exit")) {
                System.out.printf("Receive from client port %d sending it toUpperCase back data %s%n", client.getPort(), clientMessage);
                out.println(clientMessage.toUpperCase());
                System.out.println("Sent top client port " + client.getPort() + " successfully!");
                clientMessage = in.nextLine();
            }
            System.out.println("Client required exit!");
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + PORT + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}