package DemoNetworking;

import java.io.IOException;
import java.net.*;
import java.util.Enumeration;

public class DemoNetworkInterface {
    public static void main(String []args) throws IOException {
        String address = "127.0.0.1";
        int port = 1234;
//        NetworkInterface nif = NetworkInterface.getByName("bge0");
//        Enumeration<InetAddress> nifAddresses = nif.getInetAddresses();
//
//        Socket soc = new java.net.Socket();
//        soc.bind(new InetSocketAddress(nifAddresses.nextElement(), 0));
//        soc.connect(new InetSocketAddress(address, port));

        NetworkInterface nif = NetworkInterface.getByName("bge0");
        MulticastSocket ms = new MulticastSocket();
        ms.joinGroup(new InetSocketAddress(address, port), nif);
    }
}
