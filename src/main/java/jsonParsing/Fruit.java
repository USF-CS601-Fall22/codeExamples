package jsonParsing;

import com.google.gson.annotations.SerializedName;

/** Class Fruit */
public class Fruit {
    private String name;
    private String color;
    private double price;

    @SerializedName(value = "organic")
    private boolean isOrganic; // if we want to have a name of the field that is
    // different from the ones in a json file

    /**
     * Class Fruit
     * @param name name of fruit
     * @param color color
     * @param price price
     * @param isOrganic whether organic or not
     */
    public Fruit(String name, String color, double price, boolean isOrganic) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.isOrganic = isOrganic;
    }

    /**
     * toString
     * @return string representation of this fruit
     */
    @Override
    public String toString() {
        return "Fruit: " + System.lineSeparator() +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                //", price=" + price +
                ", organic=" + isOrganic;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOrganic() {
        return isOrganic;
    }


}
