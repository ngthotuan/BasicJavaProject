import java.util.List;

public class SynchronizedCounter {
    private int c = 0;
    private String lastName;
    private int nameCount;
    private List<String> nameList;
    private boolean joy;

    public synchronized void increment() {
        c++;
    }
    public synchronized void decrement() {
        c--;
    }
    public synchronized int value() {
        return c;
    }

    public void addName(String name) {
        synchronized(this) {
            lastName = name;
            nameCount++;
        }
        nameList.add(name);
    }

    public void guardedJoy() {
        // Simple loop guard. Wastes processor time. Don't do this!
        while(!joy) {
            // Waiting for joy
        }
        System.out.println("Joy has been achieved!");
    }

    public synchronized void guardedJoy2() {
        // This guard only loops once for each special event, which may not
        // be the event we're waiting for.
        while(!joy) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        System.out.println("Joy and efficiency have been achieved!");
    }

    public synchronized void notifyJoy() {
        joy = true;
        notifyAll();
    }
}

