package Socket.Proxy;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;

public class Server {
    private static final int PORT = 8888;

    public static void main(String[] args) {
        boolean listening = true;
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (listening) {
                System.out.println("Server is listening on port " + PORT);
                new ServerThread(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + PORT);
            System.exit(-1);
        }

//        try {
//            ServerSocket serverSocket = new ServerSocket(PORT);
//            while (true){
//                Socket client = serverSocket.accept();
//
//                InputStream in = client.getInputStream();
//                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
//
//                byte[] bytes = new byte[128];
//                int len = 0;
//                StringBuilder receive = new StringBuilder();
//                while((len = in.read(bytes)) > 0){
//                    receive.append(new String(Arrays.copyOf(bytes, len)));
//                    if(receive.lastIndexOf("\r\n\r\n") > 0) {
//                        break;
//                    }
//                }
//                System.out.println(receive);
//                System.out.printf("Server response for client port %d host %s%n", client.getPort(), client.getLocalSocketAddress());
//                out.println(Response.buildResponse(String.format("Server response for client port %d", client.getPort()), "text/html"));
//                client.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
