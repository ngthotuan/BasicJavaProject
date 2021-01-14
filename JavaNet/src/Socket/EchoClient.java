package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {
    private static final String HOST_IP = "localhost";
    private static final int HOST_PORT = 1234;
    public static void main(String[] args) throws IOException {

        try {
            System.out.printf("Connecting server %s port %d%n", HOST_IP, HOST_PORT);
            Socket echoSocket = new Socket(HOST_IP, HOST_PORT);
            System.out.println("Server is accepted connect! Sending data, type 'exit' to finish!");
            PrintWriter out =
                    new PrintWriter(echoSocket.getOutputStream(), true);
            Scanner in =new Scanner(new BufferedReader(new InputStreamReader(echoSocket.getInputStream())));
            Scanner stdIn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

            System.out.print("Type a message need to uppercase to server: ");
            String userInput = stdIn.nextLine();
            while (userInput != null) {
                System.out.println("Sending " + userInput + " to server");
                out.println(userInput);
                System.out.println("Sent to server successfully!");
                System.out.println("Receive from server: " + in.nextLine());
                System.out.print("Type a message need to uppercase to server: ");
                userInput = stdIn.nextLine();

            }
        }
        catch (UnknownHostException e) {
            System.err.println("Don't know about host " + HOST_IP);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    HOST_IP);
            System.exit(1);
        }
    }
}