package interfaces;

import java.util.Comparator;

public class StudentIDComparator implements Comparator<Student> {

    public int compare(Student st1, Student st2) {
        if (st1.getId() < st2.getId())
            return -1;
        else if (st1.getId() > st2.getId())
            return 1;
        else
            return 0;
    }
}
