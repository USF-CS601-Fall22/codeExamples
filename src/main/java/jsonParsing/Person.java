package jsonParsing;

public class Person {
    private String name;
    private int id;
    private String title;
    private Address address;

    public Person(String name, int id, String title, Address address) {
        this.name = name;
        this.id = id;
        this.title = title;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person: " +
                "name='" + name + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", address=" + address;
    }
}
