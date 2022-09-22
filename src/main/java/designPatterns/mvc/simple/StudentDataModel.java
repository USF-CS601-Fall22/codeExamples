package designPatterns.mvc.simple;

import java.util.*;

public class StudentDataModel implements Model {

    private Map<String, Student> studentMap = new TreeMap<>();
    private List<Observer> observerList = new ArrayList<>();

    public void addStudent(Student st) {
        studentMap.put(st.getName(), st);
    }

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observerList)
            o.update();

    }

    @Override
    public void changeName(String name1, String name2) {
     Student st = studentMap.get(name1);
     if (st == null)
         return;
     st.setName(name2);
     studentMap.remove(name1);
     studentMap.put(name2, st);
     notifyObservers();

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String stName: studentMap.keySet()) {
            sb.append(studentMap.get(stName));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

}
