import DefaultSemaphore.*;
import java.util.concurrent.Semaphore;

public class AppWithDefaultSemaphore {
    public static void main(String[] argc) {
        // Create Three Semaphores
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(0);

        // repeat times
        int timesRepeat = 10;

        // Create Three Threads
        MyThread t1 = new MyThread("A", s1, s2, timesRepeat);
        MyThread t2 = new MyThread("B", s2, s3, timesRepeat);
        MyThread t3 = new MyThread("C\n", s3, s1, timesRepeat);

        // Start Threads
        t1.start();
        t2.start();
        t3.start();

        // Wait for Threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Done!");
    }
}
