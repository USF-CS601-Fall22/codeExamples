package inheritance.bankAccountExample;

/** Demonstrates how we use  inheritance to work with objects of a super class BankAccount and
 * objects of a child class SavingsAccount
 */
public class BankAccountDemo {
    public static void main(String[] args) {
        SavingsAccount sv = new SavingsAccount("Hilary", 100.0, 1099, 0.5);
        System.out.println(sv.getBalance()); // calling the method inherited from the parent
        sv.updateBalanceWithYearlyInterest(); // calling the method in the child
        System.out.println(sv.getBalance());
        System.out.println(sv); // Java will all toString method of the child

    }
}
