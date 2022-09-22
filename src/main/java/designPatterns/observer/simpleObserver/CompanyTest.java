package designPatterns.observer.simpleObserver;

public class CompanyTest {
    public static void main(String[] args) {
        Subject company = new Company();
        Observer o1 = new MyObserver(company);
        Observer o2 = new MyObserver(company);
        Observer o3 = new MyObserver(company);

        company.registerObserver(o1);
        company.registerObserver(o2);
        company.registerObserver(o3);

        company.notifyObservers();

    }
}
