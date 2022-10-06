package multithreading.waitNotify.foodExample.efficientFood;

import multithreading.waitNotify.foodExample.inefficientFood.Food;
import multithreading.waitNotify.foodExample.inefficientFood.FoodDelivery;

public class FoodDeliveryDriver {
    public static void main(String[] args) {
        multithreading.waitNotify.foodExample.inefficientFood.Food food = new Food("Pasta Marinara");
        Thread customer = new Thread (new multithreading.waitNotify.foodExample.inefficientFood.FoodDelivery.Customer(food));
        Thread deliveryGuy = new Thread (new FoodDelivery.DeliveryGuy(food));
        customer.start();
        deliveryGuy.start();
    }

}
