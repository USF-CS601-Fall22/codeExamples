package designPatterns.observer.simpleObserver;

public class CompanyTest {
    public static void main(String[] args) {
        Subject company = new Company();
        Observer o1 = new Student(company);
        Observer o2 = new Student(company);
        Observer o3 = new Student(company);

        company.registerObserver(o1);
        company.registerObserver(o2);
        company.registerObserver(o3);

        // If the company has jobs, it will notify those who are registered as observers
        ((Company)company).addInternship("Looking for a software development intern experienced in Node.js.");
        // addInternship will call notifyObservers
    }
}
