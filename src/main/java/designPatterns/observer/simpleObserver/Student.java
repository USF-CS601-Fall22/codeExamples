package designPatterns.observer.simpleObserver;

public class Student implements  Observer {
    private Subject company;

    public Student(Subject company) {
        this.company = company;
    }

    @Override
    public void update() {
        System.out.println("Great! I will go apply for this internship now!");
        System.out.println(company.getInfo());

        // apply for a job - not shown here
    }


}
