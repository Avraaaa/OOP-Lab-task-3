package org.example;

public class CurrentAccount extends Account {

    public CurrentAccount() {}

    public CurrentAccount(String id, String name) {
        super(id, name, 0);
    }

    public CurrentAccount(String id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    public double credit(double amount) {
        setBalance(getBalance() + amount);
        return getBalance();
    }

    @Override
    public double debit(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Amount exceeded balance");
        }
        return getBalance();
    }

    @Override
    public String toString() {
        return "Account type: Current Account\nAccount id= " + getID() + ", name= " + getName() + ", balance= " + getBalance();
    }
}
