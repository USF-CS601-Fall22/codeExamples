package designPatterns.observer.simpleObserver;

import java.util.ArrayList;
import java.util.List;

public class Company implements Subject {
    private List<Observer> observerList;
    private List<String> internships;

    public Company() {
        observerList = new ArrayList<>();
        internships = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int indexOf = observerList.indexOf(observer);
        observerList.remove(indexOf);
    }

    public void addInternship(String jobDescription) {
        internships.add(jobDescription);
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer o: observerList) {
            o.update();
        }
    }

    public String getInfo() {
        return "This is a job description";
    }
}
