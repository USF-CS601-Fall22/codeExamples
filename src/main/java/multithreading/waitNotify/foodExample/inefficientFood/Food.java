package multithreading.waitNotify.foodExample.inefficientFood;

public class Food {
    private String name;
    private volatile boolean isFoodDelivered = false;

    public Food(String name) {
        this.name = name;
    }

    // Out first version: busy waiting, inefficient
    public void eat() {
        while (!isFoodDelivered) {
            System.out.println("Waiting for delivery...");
        }
        System.out.println("Eating...");
    }

    public void deliver(){
            this.isFoodDelivered = true;
            System.out.println("Food delivered");

    }

    /*public void eat() throws InterruptedException {
            synchronized(this){
                //System.out.println(Thread.currentThread().getName() + " got the lock the first time");

                while (!isFoodDelivered){
                    System.out.println("Waiting for delivery...");
                    this.wait();

                    System.out.println(Thread.currentThread().getName() + " got the lock");
                }
            }
            System.out.println(Thread.currentThread().getName() + " Eating now...");
    }

    public void deliver(){
        synchronized(this){
                this.isFoodDelivered = true;
                System.out.println("Food delivered");
                // this.notify();
                this.notifyAll();
        }
    }
    */
}

