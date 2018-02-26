package paner.proxy.demo;

/**
 * Created by www-data on 17/2/19.
 */
public class ElectricCar implements  Rechargable,Vehicle {
    public void recharge() {
        System.out.println("Electric Car is Recharging...");
    }

    public void drive() {
        System.out.println("Electric Car is Moving silently...");
    }
}
