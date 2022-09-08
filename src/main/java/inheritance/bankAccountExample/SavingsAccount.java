package inheritance.bankAccountExample;

import inheritance.bankAccountExample.BankAccount;

public class SavingsAccount extends BankAccount {
    private double interestRate; // yearly interest rate
    public SavingsAccount(String name, double balance, long number, double interestRate) {
        super(name, balance, number);
        this.interestRate = interestRate;
    }

    public void updateBalanceWithYearlyInterest() {
        double currBalance  = getBalance();
        setBalance(currBalance + currBalance * interestRate / 100.0);

    }

    @Override
    public String toString() {
        return super.toString() + ", interest rate: " + interestRate;
    }

}
