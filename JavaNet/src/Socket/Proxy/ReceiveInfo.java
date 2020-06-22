package Socket.Proxy;

public class ReceiveInfo {
    private String method, host, page;
    public ReceiveInfo(String request){
//        System.out.printf("REQUEST:%n%s" , request);
        int pos = request.indexOf(" ");
        this.method = request.substring(0, pos).toUpperCase();//GET
        request = request.substring(pos+1);

        pos = request.indexOf(" HTTP/1.");
        this.page = request.substring(0, pos);//http://example.com/img/1.jpg

        pos = request.indexOf("Host");
        request = request.substring(pos+6);
        pos = request.indexOf("\n");
        this.host = request.substring(0, pos);//example.com
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "ReceiveInfo{" +
                "method='" + method + '\'' +
                ", host='" + host + '\'' +
                ", page='" + page + '\'' +
                '}';
    }
}
