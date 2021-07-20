/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ksg
 */
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class ReadWriteLockExample {
    public static void main(String args[])
    {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Map<String, String> map = new HashMap<>();
        map.put("str", "before");
        ReadWriteLock lock = new ReentrantReadWriteLock();

        Runnable writeTask = () -> {
            lock.writeLock().lock();
            try
            {
                map.put("str", "after");
                System.out.println("writeTask");
                TimeUnit.SECONDS.sleep(3);
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            finally
            {
                lock.writeLock().unlock();
            }
        };

        Runnable readTask = () -> {
            lock.readLock().lock();
            try
            {
                System.out.println("readTask");
                System.out.println(map.get("str"));
                TimeUnit.SECONDS.sleep(3);
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            finally
            {
                lock.readLock().unlock();
            }
        };

        executor.submit(writeTask);
        executor.submit(readTask);
        executor.submit(readTask);

//        executor.shutdown();
        try
        {
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e)
        {
            System.out.println("shutdown interrupted");
        }
        finally {
            executor.shutdownNow();
        }
    }
}
