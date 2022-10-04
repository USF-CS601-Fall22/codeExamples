package multithreading.synchronization;

public class SynchronizedCounterExample {
    private SynchronizedCounter counter;

    public SynchronizedCounterExample(SynchronizedCounter counter) {
        this.counter = counter;
    }

    public class AdditionWorker implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        }
    }

    public class SubtractionWorker implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.decrement();
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedCounter counter = new SynchronizedCounter();
        SynchronizedCounterExample ex = new SynchronizedCounterExample(counter);
        Thread thread1 = new Thread(ex.new AdditionWorker());
        Thread thread2 = new Thread(ex.new SubtractionWorker());
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(counter.value());
    }
}
