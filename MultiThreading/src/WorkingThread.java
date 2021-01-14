public class WorkingThread extends Thread {
    public WorkingThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.printf("i = %d, Thread %s is alive = %s%n", i, this.getName(), this.isAlive());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }
}
