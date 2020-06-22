public class Drop {
    // Message sent from producer to consumer.
    private String message;

    // true if consumer should wait for producer to send message,
    // false if producer should wait for onsumer to retrieve message.
    private boolean empty = true;

    public synchronized String take() {
        // Wait until message is available.
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        // Toggle status.
        empty = true;
        System.out.println("Consumer");
        // Notify producer that status has changed.
        notifyAll();
        return message;
    }

    public synchronized void put(String message) {
        // Wait until message has been retrieved.
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        // Toggle status.
        empty = false;
        // Store message.
        this.message = message;
        System.out.println("Producer");
        // Notify consumer that status has changed.
        notifyAll();
    }
}