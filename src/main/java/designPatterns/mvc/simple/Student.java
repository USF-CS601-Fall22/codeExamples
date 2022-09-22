package designPatterns.mvc.simple;

public class Student {
    private String name;
    private double GPA;
    private int id;

    public Student(String name, double GPA, int id) {
        this.name = name;
        this.GPA = GPA;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return GPA;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name  + ", " + id + ", " + GPA;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        Student o = (Student)obj;
        if (this.name == o.name && this.GPA == o.GPA && this.id == o.id)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return (int) (33*33*id + 33*name.hashCode() + GPA);
    }
}
