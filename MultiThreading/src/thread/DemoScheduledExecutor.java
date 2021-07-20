import java.util.List;
import java.util.concurrent.*;

public class DemoScheduledExecutor {
    public static void main(String []args){

        ScheduledExecutorService executor = Executors
                .newSingleThreadScheduledExecutor();

        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        executor.schedule(runnableTask, 1, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(runnableTask, 100,
                450, TimeUnit.MILLISECONDS);
        executor.scheduleWithFixedDelay(runnableTask, 100, 150,
                TimeUnit.MILLISECONDS);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

    }
}
