package MySemaphorPackage;

public class MyThread extends Thread{
    private String str;
    private CountingSemaphore s1;
    private CountingSemaphore s2;
    private int timesRepeat;

    // Constructor
    public MyThread(String str, CountingSemaphore s1, CountingSemaphore s2, int timesRepeat) {
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
                s1.release();
                System.out.print(str);
                s2.take();
            } catch (InterruptedException E) {
                E.printStackTrace();
            }
        }
    }
}
