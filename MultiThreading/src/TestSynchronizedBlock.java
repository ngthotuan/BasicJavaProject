

public class TestSynchronizedBlock {
    static class Table {
        void printTable(int n) {
            synchronized (this) { // khoi dong bo (synchronized block)
                for (int i = 1; i <= 5; i++) {
                    System.out.println(n * i);
                    try {
                        Thread.sleep(400);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        } // Ket thuc phuong thuc
    }
    public static void main(String args[]) {
        final Table obj = new Table();// tao object duy nhat
        Thread t1 = new Thread() {
            public void run() {
                obj.printTable(1);
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                obj.printTable(100);
            }
        };
/*
        // new -> static synchronize
        final Table obj2 = new Table();
        Thread t3 = new Thread(){
            @Override
            public void run() {
                obj2.printTable(1000);
            }
        };
        Thread t4 = new Thread(){
            @Override
            public void run() {
                obj2.printTable(10000);
            }
        };
        //end new

 */
        t1.start();
        t2.start();
//        t3.start();
//        t4.start();
    }
}