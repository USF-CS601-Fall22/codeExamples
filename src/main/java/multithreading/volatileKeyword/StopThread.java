package multithreading.volatileKeyword;

import java.util.concurrent.TimeUnit;

/** Example from Effective Java book. The program does not stop.
 * The issue is with visibility. */
public class StopThread {
    private static boolean stopRequested = false;

    public static void main (String[] args) {

        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                 i++;
                //System.out.println(i);
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
