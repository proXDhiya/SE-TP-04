package MySemaphorPackage;

public class CountingSemaphore {
    private int signal;

    // auto constructor
    public CountingSemaphore() {
        this.signal = 0;
    }

    // constructor with values
    public CountingSemaphore(int n) {
        this.signal = n;
    }
    
    // Function to wait for a signal
    public synchronized void release() {
        this.signal++;
        this.notify();
    }

    // Function to release a signal
    public synchronized void acquire() throws InterruptedException {
        while(this.signal == 0) {
            wait();
        }
        this.signal--;
    }
}
