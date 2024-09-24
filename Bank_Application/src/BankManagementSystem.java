import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.random.*;

class Account {
    private int accountNumber;
    private String accountHolderName;
    private String accountType;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(int accountNumber, String accountHolderName, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }

    public void addMoney(double amount) {
        balance += amount;
        addTransaction("Deposit: " + amount);
    }

    public void withdrawMoney(double amount) {
        if (balance >= amount) {
            balance -= amount;
            addTransaction("Withdrawal: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void printStatement() {
        System.out.println("Account Statement for account number " + accountNumber);
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public void printAccountInfo() {
        System.out.println("Account number: " + accountNumber);
        System.out.println("Account holder name: " + accountHolderName);
        System.out.println("Account type: " + accountType);
        System.out.println("Balance: " + balance);
    }
}

class Bank {
    private ArrayList<Account> accounts;
    private int nextAccountNumber;
    Random rn = new Random();

    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = rn.nextInt(1000);
    }

    public void openAccount(String accountHolderName, String accountType, double initialBalance) {
        Account account = new Account(nextAccountNumber, accountHolderName, accountType, initialBalance);
        accounts.add(account);
        System.out.println("Account created successfully. Account number is " + nextAccountNumber);
        nextAccountNumber++;
    }

    public void addMoney(int accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.addMoney(amount);
            System.out.println("Money added successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdrawMoney(int accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.withdrawMoney(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void printStatement(int accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.printStatement();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void printAccountInfo(int accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.printAccountInfo();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void switchAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account number:");
        int accountNumber = scanner.nextInt();
        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("Switched to account number " + accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void searchAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter search query:");
        String query = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (Account account : accounts) {
            if (String.valueOf(account.getAccountNumber()).contains(query)
                    || account.getAccountHolderName().toLowerCase().contains(query)) {
                System.out.println(account.getAccountNumber() + " - " + account.getAccountHolderName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No accounts found.");
        }
    }

    public void listAllAccounts() {
        for (Account account : accounts) {
            System.out.println(account.getAccountNumber() + " - " + account.getAccountHolderName()
                    + " - " + account.getAccountType() + " - " + account.getBalance());
        }
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount) {
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);
        if (fromAccount == null || toAccount == null) {
            System.out.println("One or both accounts not found.");
        } else if (fromAccount.getBalance() < amount) {
            System.out.println("Insufficient balance.");
        } else {
            fromAccount.withdrawMoney(amount);
            toAccount.addMoney(amount);
            System.out.println("Transfer successful.");
        }
    }

    private Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}

public class BankManagementSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter choice:");
            System.out.println("1. Open account");
            System.out.println("2. Add money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Account statement");
            System.out.println("5. Account info");
            System.out.println("6. Switch account");
            System.out.println("7. Search account");
            System.out.println("8. List all accounts");
            System.out.println("9. Transfer money");
            System.out.println("10. Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter account holder name:");
                    scanner.nextLine();
                    String accountHolderName = scanner.nextLine();
                    System.out.println("Enter account type:");
                    String accountType = scanner.nextLine();
                    System.out.println("Enter initial balance:");
                    double initialBalance = scanner.nextDouble();
                    bank.openAccount(accountHolderName, accountType, initialBalance);
                    break;
                case 2:
                    System.out.println("Enter account number:");
                    int accountNumber = scanner.nextInt();
                    System.out.println("Enter amount to add:");
                    double amountToAdd = scanner.nextDouble();
                    bank.addMoney(accountNumber, amountToAdd);
                    break;
                case 3:
                    System.out.println("Enter account number:");
                    int accountNumberToWithdrawFrom = scanner.nextInt();
                    System.out.println("Enter amount to withdraw:");
                    double amountToWithdraw = scanner.nextDouble();
                    bank.withdrawMoney(accountNumberToWithdrawFrom, amountToWithdraw);
                    break;
                case 4:
                    System.out.println("Enter account number:");
                    int accountNumberForStatement = scanner.nextInt();
                    bank.printStatement(accountNumberForStatement);
                    break;
                case 5:
                    System.out.println("Enter account number:");
                    int accountNumberForInfo = scanner.nextInt();
                    bank.printAccountInfo(accountNumberForInfo);
                    break;
                case 6:
                    bank.switchAccount();
                    break;
                case 7:
                    bank.searchAccount();
                    break;
                case 8:
                    bank.listAllAccounts();
                    break;
                case 9:
                    System.out.println("Enter account number to transfer from:");
                    int fromAccountNumber = scanner.nextInt();
                    System.out.println("Enter account number to transfer to:");
                    int toAccountNumber = scanner.nextInt();
                    System.out.println("Enter amount to transfer:");
                    double amountToTransfer = scanner.nextDouble();
                    bank.transferMoney(fromAccountNumber, toAccountNumber, amountToTransfer);
                    break;
                case 10:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
