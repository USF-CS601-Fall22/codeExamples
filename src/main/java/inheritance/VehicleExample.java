package inheritance;

public class VehicleExample {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle(4, 5, "094251", "Ford");
        Truck tr1 = new Truck(2, 2, "587036", "Jeep", false);

        Vehicle v2 = tr1;      //upcasting. always ok
        Truck tr2 = (Truck)v2; //downcasting. ok
        // tr2 = (Truck)v1; // what will happen if you uncomment and run the code?
        //System.out.println(v1.getClass().getSimpleName());

    }
}
