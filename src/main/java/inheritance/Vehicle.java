package inheritance;
// Super class of class Truck.

class Vehicle {
    private int numDoors;
    private int numSeats;
    private String vin;
    private String make;

    public Vehicle(int numDoors, int numSeats, String vin, String make) {
        this.numDoors= numDoors;
        this.numSeats = numSeats;
        this.vin = vin;
        this.make = make;
    }

    public String toString() {
        return make +  " " + numDoors + " " + numSeats;
    }

    // Other methods

}



