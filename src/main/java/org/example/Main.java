package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account[] accounts = new Account[50];
        int accountCount = 0;
        boolean found = false;
        double balance;
        String id;
        accounts[accountCount++] = new SavingsAccount("3", "Dustin", 3000);
        accounts[accountCount++] = new CurrentAccount("5", "Dave", 500);
        accounts[accountCount++] = new DepositPremiumAccount("4", "Leo", 1200);

        while (true) {
            System.out.println("What do you want to do");
            System.out.println("1.Add account");
            System.out.println("2.Display account");
            System.out.println("3.Debit");
            System.out.println("4.Credit");
            System.out.println("5.Transfer");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    int type;
                    System.out.println("Enter account name");
                    String name = scanner.nextLine();
                    System.out.println("Enter account id");
                    id = scanner.nextLine();
                    System.out.println("Enter account balance");
                    balance = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("What type of account do you want to add?");
                    System.out.println("1. Current Account");
                    System.out.println("2. Savings Account");
                    System.out.println("3. Deposit Premium Account");
                    type = scanner.nextInt();
                    scanner.nextLine();
                    if (type == 1) {
                        accounts[accountCount++] = new CurrentAccount(id, name, balance);
                    } else if (type == 2) {
                        accounts[accountCount++] = new SavingsAccount(id, name, balance);
                    } else if (type ==3) {
                        accounts[accountCount++] = new DepositPremiumAccount(id, name, balance);

                    }
                    break;

                case 2:
                    found = false;
                    System.out.println("Enter account id: ");
                    id = scanner.nextLine();
                    for (int i = 0; i < accountCount; i++) {
                        if (id.equals(accounts[i].getID())) {
                            System.out.println(accounts[i].toString());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found");
                    }
                    break;

                case 3:
                    found = false;
                    System.out.println("Enter account id: ");
                    id = scanner.nextLine();
                    System.out.println("Enter balance to debit: ");
                    balance = scanner.nextDouble();
                    scanner.nextLine();
                    for (int i = 0; i < accountCount; i++) {
                        if (id.equals(accounts[i].getID())) {
                            accounts[i].debit(balance);
                            double afterDebit = accounts[i].getBalance();
                            System.out.println("Current Balance: " + afterDebit);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found");
                    }
                    break;
                case 4:
                    found = false;
                    System.out.println("Enter account id: ");
                    id = scanner.nextLine();
                    System.out.println("Enter amount to credit: ");
                    balance = scanner.nextDouble();
                    scanner.nextLine();
                    for (int i = 0; i < accountCount; i++) {
                        if (id.equals(accounts[i].getID())) {
                            accounts[i].credit(balance);
                            double afterCredit = accounts[i].getBalance();
                            System.out.println("Current Balance: " + afterCredit);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found");
                    }
                    break;

                case 5:
                    System.out.println("Enter your account id: ");
                    String id1 = scanner.nextLine();
                    System.out.println("Enter your destination id: ");
                    String id2 = scanner.nextLine();
                    int index1 = 0;
                    int index2 = 0;
                    boolean found1 = false;
                    boolean found2 = false;

                    for (int i = 0; i < accountCount; i++) {
                        if (id1.equals(accounts[i].getID())) {
                            found1 = true;
                            index1 = i;
                            break;
                        }
                    }
                    for (int i = 0; i < accountCount; i++) {
                        if (id2.equals(accounts[i].getID())) {
                            found2 = true;
                            index2 = i;
                            break;
                        }
                    }

                    if (!found1) {
                        System.out.println("Source Account not found");


                    }
                    if (!found2) {
                        System.out.println("Destination Account not found");
                    }
                    if (found1 && found2) {
                        System.out.println("Enter amount to transfer: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        accounts[index1].transferTo(accounts[index2], amount);
                        System.out.println("Transfer Successful");
                        System.out.println("Balance in your account after transfer: " + accounts[index1].getBalance());
                    }
                    break;
                case 6:
                    return;
            }

        }
    }

}
