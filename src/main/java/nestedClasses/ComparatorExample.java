package nestedClasses;

import java.awt.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ComparatorExample {

    public static void main(String[] args) {
        Comparator<Student> comp = new Comparator<>() {
            @Override
            public int compare(Student s1, Student s2) {
                 return s1.toString().compareTo(s2.toString());
            }
        };

        Set<Student> students = new TreeSet<>(comp);
        students.add(new Student("Neha Singh", 0));
        students.add(new Student ("Xue Liang", 1));
        students.add(new Student("Allison K", 2));
        System.out.println(students);


        /*
        //Set<Student> students = new TreeSet<Student>((s1, s2) -> s1.toString().compareTo(s2.toString()));
        students.add(new Student("Neha Singh"));
        students.add(new Student ("Xue Liang"));
        students.add(new Student("Allison K"));
        System.out.println(students); */
    }

}
