package interfaces;

public class Student implements Comparable<Student> {
    public static final double GPA_THRES = 0.01;
    private String name;
    private int id;
    private double averageGPA;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Student(String name, int id, double averageGPA) {
        this.name = name;
        this.id = id;
        this.averageGPA = averageGPA;
    }

    @Override
    public int compareTo(Student otherStudent) {
        if (Math.abs(this.averageGPA - otherStudent.averageGPA ) < GPA_THRES) {
            return 0;
        }
        else
            if (this.averageGPA < otherStudent.averageGPA)
                return -1;
            else
                return 1;

        /*if (this.id < otherStudent.id)
            return -1;
        else if (this.id == otherStudent.id){
            return 0;
        }
        else
            return 1;*/
        //return this.id - otherStudent.id;

       //return name.compareTo(otherStudent.name);
    }

    @Override
    public String toString() {
        return name + ": " + id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
