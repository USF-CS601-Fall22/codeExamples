package multithreading.volatileKeyword;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/** Example from Effective Java book */
public class StopThreadAtomic {
    private static final AtomicBoolean stopRequested = new AtomicBoolean(false);

    public static void main (String[] args) {
        // run
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (stopRequested.get() == false) {
                i++;
            } // while
        }); //Thread

        backgroundThread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException e) {
            System.out.println("Thread was interrupted.");
        }

        stopRequested.set(true);
    }
}
