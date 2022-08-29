package javaBasics;

/** The driver class for the Bank account example */
public class BankAccountExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100.0, "Jones");
        account.deposit(200.0);
        account.withdraw(50.0);
        System.out.println(account.getBalance());


        BankAccountExample ex1 = new BankAccountExample();
        ex1.test1(account); // account will change
        System.out.println(account.getBalance());


        BankAccountExample ex2 = new BankAccountExample();
        ex2.test2(account); // account will NOT change
        System.out.println(account.getBalance());

    }

    /** Methods  test1 and test2 demonstrate that Java passes by value and the implications of that
     * @param ba
     */
    public void test1(BankAccount ba) {
        ba.withdraw(50); // WILL change the balance in the account object that ba references
    }

    public void test2(BankAccount ba) {
        // At this point, ba is a copy of account, so points at the same object

        // See what happens after this line:
        ba = new BankAccount(200, "Olga");
        ba.withdraw(100);
        // ba is now pointing at a new object, that will be destroyed after this method executes
        // This will NOT affect account variable defined in line 6 of this file
    }
}
