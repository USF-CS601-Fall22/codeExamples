package reflection;

public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student: " + System.lineSeparator() +
                "First name: " + getFirstName();
    }

    private String getFirstName() {
        return name.split(" ")[0];
    }
}
