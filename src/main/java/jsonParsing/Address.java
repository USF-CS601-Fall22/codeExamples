package jsonParsing;

public class Address {
    private String state;
    private String city;
    private String street;
    private long number;

    public Address(String state, String city, String street, long number) {
        this.state = state;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Address: " + System.lineSeparator() +
                "state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number;
    }
}
