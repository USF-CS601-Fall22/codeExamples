package designPatterns.staticFactoryMethods;

import java.io.File;
import java.util.Scanner;

public class EnemyShipExample {
    public static void main(String[] args) {
        EnemyShipExample ex = new EnemyShipExample();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the type of the ship: ");
        String type = sc.nextLine();
        String fullName = ex.getClass().getPackageName()+ "." +  type;
        //System.out.println(fullName);
        EnemyShip myShip = EnemyShip.getInstance(fullName);
        if (myShip != null)
         myShip.attack();
    }
}
