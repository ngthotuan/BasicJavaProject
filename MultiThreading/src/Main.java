public class Main {
    public static void main(String[] args) {
        Thread t1 = new WorkingThread("t1");
        Thread t2 = new WorkingThread("t2");
        Thread t3 = new WorkingThread("t3");

        System.out.printf("Id thread 1 %d%n", t1.getId());
        System.out.printf("Id thread 2 %d%n", t2.getId());
        System.out.printf("Id thread 3 %d%n", t3.getId());

        t1.setPriority(1);
        t2.setPriority(5);
        t3.setPriority(10);

        t1.start();
        t2.start();
        t3.start();
        try {
            Thread.sleep(1000);
            t1.suspend();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
