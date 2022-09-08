package inheritance.bankAccountExample;

/** Class Bank Account */
public class BankAccount {
    // Instance variables
    private String name; // name of the owner
    private double balance; // balance
    private long number; // account number

    /**
     * Constructor
     * @param name name of the owner
     * @param balance balance in dollars
     * @param number account number
     */
    public BankAccount(String name, double balance, long number) {
        this.name = name;
        this.balance = balance;
        this.number = number;
    }

    /**
     * Withdraws money from the account
     * @param amt amount to withdraw
     */
    public void withdraw(double amt) {
        if (balance - amt < 0) {
            throw new IllegalArgumentException("Invalid withdraw amount");
        }
        balance -= amt;

    }

    /**
     * Deposits money into account
     * @param amt amount to deposit
     */
    public void deposit(double amt) {
        balance = balance + amt;

    }

    /**
     *  Getter for balance
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Setter for the balance
     * @param balance new balance
     */
    public void setBalance(double balance) {
        if (balance >=0)
            this.balance = balance;
    }

    /**
     * toString
     * @return string representation of this account. For now just prints the balance
     */
    @Override
    public String toString() {
        return "name: " + name + ", balance: " + balance;
    }
}
