package multithreading.waitNotify.foodExample.efficientFood;

public class Food {
    private String name;
    private volatile boolean isFoodDelivered = false;

    public Food(String name) {
        this.name = name;
    }

    public void eat() throws InterruptedException {
            synchronized(this){
                System.out.println(Thread.currentThread().getName() + " got the lock for the synchronized block");

                while (!isFoodDelivered){
                    System.out.println("Waiting for delivery.... Released the lock");
                    this.wait();
                    System.out.println(Thread.currentThread().getName() + " got notified and got the lock");
                }
            }
            System.out.println(Thread.currentThread().getName() + " Eating now...");
    }

    public void deliver(){
        synchronized(this){
                this.isFoodDelivered = true;
                System.out.println("Food delivered");
                //this.notify();
                this.notifyAll();
        }
    }
}

