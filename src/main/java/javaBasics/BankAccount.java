package javaBasics;

/** Bank Account class */
public class BankAccount {
    // Instance variables:
    private double balance;
    private String owner;

    /**
     * Constructor
     * @param balance current balance
     * @param owner name of owner
     */
   public BankAccount(double balance, String owner) {
       this.balance = balance;
       this.owner = owner;
   }

    /**
     * Getter for the balance
     * @return current balance
     */
   public double getBalance() {
       return this.balance;
   }

    /**
     * Deposit
     * @param amount amount of money to deposit
     */
   public void deposit(double amount) {
       this.balance += amount;
   }

    /**
     * Withdraw.
     * Throws an exception if there is not enough money in the account.
     * @param amount amount of money to withdraw
     *
     */
   public void withdraw(double amount) {
       if (this.balance - amount < 0) {
           throw new IllegalArgumentException();
       }
       this.balance = this.balance - amount;
   }

    /**
     * toString method eturns a string representation of the account
     * @return a string representation of the account
     */
   public String toString() {
       return owner + ",  " + balance;
   }


}
