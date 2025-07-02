package org.example;

public class DepositPremiumAccount extends Account {
    private int depositCount = 0;

    public DepositPremiumAccount() {}

    public DepositPremiumAccount(String id, String name) {
        super(id, name, 0);
    }

    public DepositPremiumAccount(String id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    public double credit(double amount) {
        if (amount > 0) {
            depositCount++;
            setBalance(getBalance() + amount + (getBalance() * (7.0F / 100)));
        }

        return getBalance();

    }

    @Override
    public double debit(double amount) {
        if (amount <= getBalance() && depositCount >= 5) {
            setBalance(getBalance() - amount);
        } else if (depositCount < 5) {
            System.out.println("Cannot Withdraw before 5 deposits");
        } else {
            System.out.println("Amount exceeded balance");
        }
        return getBalance();
    }

    @Override
    public double transferTo(Account another, double amount) {
        System.out.println("Transfer not allowed from Deposit Premium Account");
        return getBalance();
    }


    @Override
    public String toString() {
        return "Account type: Deposit Premium Account\nAccount id= " + getID() + ", name= " + getName() + ", balance= " + getBalance();
    }
}
