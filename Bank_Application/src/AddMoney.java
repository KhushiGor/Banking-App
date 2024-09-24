import java.util.Scanner;

interface AddTransaction extends Transaction {
    public abstract void AddMoney();

}

public class AddMoney implements AddTransaction {
    public void AddMoney() {
        System.out.println("Enter Account Number:");
        Scanner sc = new Scanner(System.in);
        int ac_no = sc.nextInt();
        System.out.println("Enter Amount:");
        long amount = sc.nextInt();
        BankApp addmoney = new BankApp();
        addmoney.acc_balance += amount;
    }

}
