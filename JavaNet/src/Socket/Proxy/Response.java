package Socket.Proxy;

import java.util.Date;

public class Response {
    public static String buildResponse(String data, String type){
//        HTTP/1.0 200 OK
//        Date: Fri, 08 Aug 2003 08:12:31 GMT
//        Server: Apache/1.3.27 (Unix)
//                MIME-version: 1.0
//        Last-Modified: Fri, 01 Aug 2003 12:45:26 GMT
//        Content-Type: text/html
//        Content-Length: 2345
//                ** a blank line *
//                <HTML> ...
        StringBuilder builder = new StringBuilder();
        builder.append("HTTP/1.1 200 OK\n");
        builder.append("Date: ").append(new Date()).append("\n");
        builder.append("Server: Java Proxy Server\n");
        builder.append("Content-Type: ").append(type).append("\n");
        builder.append("Content-Length: ").append(data.length()).append("\n\n");
        builder.append(data);

        return builder.toString();
    }
}
