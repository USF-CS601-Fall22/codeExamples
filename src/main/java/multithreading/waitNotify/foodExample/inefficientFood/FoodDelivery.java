package multithreading.waitNotify.foodExample.inefficientFood;

public class FoodDelivery {

    public static class Customer implements Runnable {
        private Food food;

        public Customer(Food food) {
            this.food = food;
        }

        @Override
        public void run() {
            //try {
                food.eat();
            //}
            //catch (InterruptedException e) {
              //  System.out.println(e);
            //}
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
}

