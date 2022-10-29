package DefaultSemaphore;
import java.util.concurrent.Semaphore;

public class MyThread extends Thread {
    private String str;
    private Semaphore s1;
    private Semaphore s2;
    private int timesRepeat;

    // Constructor
    public MyThread(String str, Semaphore s1, Semaphore s2, int timesRepeat) {
        super();
        this.str = str;
        this.s1 = s1;
        this.s2 = s2;
        this.timesRepeat = timesRepeat;
    }

    // Run method
    public void run() {
        for (int i = 0; i < timesRepeat; i++) {
            try {
                s1.acquire();
                System.out.print(str);
                s2.release();
            } catch (InterruptedException E) {
                E.printStackTrace();
            }
        }
    }
}
