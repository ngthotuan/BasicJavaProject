package Socket.Proxy;

import com.sun.net.httpserver.HttpsParameters;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class ServerThread extends Thread {
    private Socket client = null;

    public ServerThread(Socket socket){
        super("ServerThread");
        this.client = socket;
    }



    @Override
    public void run() {
        System.out.println("run client port : "+ client.getPort());
        try{
            InputStream in = client.getInputStream();
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            // Get from client
            byte[] bytes = new byte[1024];
            int len = 0;
            StringBuilder receive = new StringBuilder();
            while((len = in.read(bytes)) > 0){
                receive.append(new String(Arrays.copyOf(bytes, len)));
                if(receive.lastIndexOf("\r\n\r\n") > 0) {
                    break;
                }
            }
            // read request
            ReceiveInfo info = new ReceiveInfo(receive.toString());
            if(info.getMethod().equals("POST")){
                System.out.println(receive);
            }
            System.out.printf("Server response for client method %s host %s%n", info.getMethod(), info.getHost());

            if(!info.getMethod().equals("GET") && !info.getMethod().equals("POST")){
                out.println(Response.buildResponse("Could support this method!", "text/html"));
            }
            else{
                URL url = new URL(info.getPage());
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setRequestMethod(info.getMethod());

//                Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(connection.getInputStream())));
//                while (sc.hasNext()){
//                    out.println(sc.nextLine());
//                }
                // sendback client
                try {
//                    InputStream inputStream = connection.getInputStream();
                    InputStream inputStream = url.openStream();
                    OutputStream outputStream = client.getOutputStream();
                    while((len = inputStream.read(bytes)) > 0){
                        outputStream.write(Arrays.copyOf(bytes, len));
                    }
                } catch (IOException ex){
                    out.println(Response.buildResponse(ex.getMessage(), "text/html"));
                }
            }

            client.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
