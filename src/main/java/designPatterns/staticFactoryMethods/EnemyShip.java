package designPatterns.staticFactoryMethods;

import dependencyInjection.Dictionary;
import dependencyInjection.MySpellChecker;

import java.lang.reflect.InvocationTargetException;

public interface EnemyShip {

    void attack();

    static EnemyShip getInstance(String type) {
        /*if (type.endsWith("UFOShip"))
            return new UFOShip();
        else if (type.endsWith("PirateShip"))
                return new PirateShip();
        return null; */
        try {
            Class cl = Class.forName(type);
            Object obj = cl.getDeclaredConstructor().newInstance();
            EnemyShip ship = (EnemyShip) obj;
            return ship;

        } catch (ClassNotFoundException | NoSuchMethodException| InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(e);
        }
        return null;

       }
}
