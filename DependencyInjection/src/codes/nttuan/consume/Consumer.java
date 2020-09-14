package codes.nttuan.consume;

public interface Consumer {
    public void processMessage(String mess, String rec);
}
