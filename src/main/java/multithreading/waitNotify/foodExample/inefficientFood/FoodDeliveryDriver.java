package multithreading.waitNotify.foodExample.inefficientFood;

public class FoodDeliveryDriver {
    public static void main(String[] args) {
        Food food = new Food("Pasta Marinara");
        Thread customer = new Thread (new FoodDelivery.Customer(food));
        Thread deliveryGuy = new Thread (new FoodDelivery.DeliveryGuy(food));
        customer.start();
        deliveryGuy.start();
    }

}
