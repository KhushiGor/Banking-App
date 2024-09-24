
import java.util.Scanner;

interface WithdrawTransaction {
    void WithdrawMoney();
}

public class WithdrawMoney implements WithdrawTransaction {
    public void WithdrawMoney() {
        System.out.println("Enter the Account Number:");
        Scanner sc = new Scanner(System.in);
        int ac_no = sc.nextInt();
        System.out.println("Enter Amount:");
        long amount = sc.nextLong();
        BankApp reduce = new BankApp();
        if (amount > reduce.acc_balance) {
            System.out.println("Sorry... No Sufficient Amount Available");
            System.out.println("Your available Balance is " + reduce.acc_balance);
        } else {
            reduce.acc_balance -= amount;
            System.out.println("Amount Is Withdrawaled Sucessfully...!!");
            System.out.println("Your available Balance is " + reduce.acc_balance);
        }
    }
}
