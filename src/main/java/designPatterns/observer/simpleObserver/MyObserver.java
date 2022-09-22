package designPatterns.observer.simpleObserver;

public class MyObserver implements  Observer {
    private Subject company;

    public MyObserver(Subject company) {
        this.company = company;
    }

    @Override
    public void update() {
        System.out.println("Great! I will go apply for an internship now!");
        System.out.println(company.getInfo());

        // apply for a job - not shown here
    }


}
