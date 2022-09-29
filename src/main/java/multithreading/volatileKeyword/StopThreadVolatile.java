package multithreading.volatileKeyword;

import java.util.concurrent.TimeUnit;

/** Example from Effective Java book.
 * This version of the program stops because stopRequested is volatile
 * (all reads are from the main memory, all writes are to the main memory). */
public class StopThreadVolatile {
    private static volatile boolean stopRequested;

    public static void main (String[] args) {
        // run
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
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

        stopRequested = true;
    }
}
