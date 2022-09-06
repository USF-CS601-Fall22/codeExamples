package inheritance;

/** Subclass of class Vehicle */
public class Truck extends Vehicle {
    private boolean isPickup;

    public Truck(int numDoors, int numSeats, String vin, String make, boolean isPickup) {
        super(numDoors, numSeats, vin, make);
        this.isPickup = isPickup;
    }

    public String toString() {
        return super.toString() + System.lineSeparator() + isPickup;
    }
    // other methods

}
