public class Thread2 extends Thread{
    private String Name;

    public Thread2(String name) {
        Name = name;
    }

    @Override
    public void run() {
        for (int i=0;i<5;i++)
        {
            System.out.println("Day La THread "+this.Name);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread "+this.Name+" is stop");
    }
}
