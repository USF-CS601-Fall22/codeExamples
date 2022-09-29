package multithreading.volatileKeyword;

import java.util.concurrent.TimeUnit;

/** Example from Effective Java book */
public class StopThreadSynchronization {
    private static boolean stopRequested;

    public static synchronized void requestStop() {
        stopRequested = true;
    }

    public static synchronized boolean getStopRequested() {
        return stopRequested;
    }

    public static void main (String[] args) {
        // run
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!getStopRequested()) {
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

        requestStop();
    }
}
