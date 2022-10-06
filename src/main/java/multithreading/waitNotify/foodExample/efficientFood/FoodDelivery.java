package multithreading.waitNotify.foodExample.efficientFood;

public class FoodDelivery {

    public static class Customer implements Runnable {
        private Food food;

        public Customer(Food food) {
            this.food = food;
        }

        @Override
        public void run() {
            try {
                food.eat();
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }


    public static class DeliveryGuy implements Runnable {
        private Food food;

        public DeliveryGuy(Food food) {
            this.food = food;
        }

        @Override
        public void run() {
            food.deliver();

        }

    }

    public static void main(String[] args) {
        Food food = new Food("Pasta Marinara");
        Thread customer = new Thread (new Customer(food));
        Thread customerOther = new Thread (new Customer(food));

        Thread deliveryGuy = new Thread (new DeliveryGuy(food));
        customer.start();
        customerOther.start();
        deliveryGuy.start();

    }


}

