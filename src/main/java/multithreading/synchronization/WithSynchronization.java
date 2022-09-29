package multithreading.synchronization;

/**  Based on NoSynchronization example */
public class WithSynchronization {
    private int x = 0;
    private Object lock  = new Object(); // belongs to the outer class, will be shared by AdditionTask and SubtractionTask

    private class AdditionTask implements Runnable {
        public void run() {

            for (int i = 0; i < 1000; i++) {
                synchronized (lock) {
                    x++;
                }
            }
        }

    }

    private class SubtractionTask implements Runnable {
        public void run() {
            for (int i = 0; i < 1000; i++) {
                synchronized(lock) {
                    x--;
                }
            }
        }
    }

    public void createThreads() throws InterruptedException {
        Thread t1 = new Thread(new AdditionTask());
        Thread t2 = new Thread(new SubtractionTask());
        t1.start();
        t2.start();
        // wait for threads 1 and 2 to  finish
        t1.join();
        t2.join();

        // Note: we are reading x below, but no need to synchronize here since t1 and t2 finished
        if (x != 0) // will only print something if x i not 0
            System.out.print(x + " ");
        // System.out.println("Done");
    }

    public static void main(String[] args)  {
        WithSynchronization ns = new WithSynchronization();
        try {
            //for (int i = 0; i < 10000; i++) {
            ns.createThreads();
            //}
        }
        catch  (InterruptedException e) {
            System.out.println("Thread got interrupted: " + e);
        }
        //System.out.println("Done");
    }

}

