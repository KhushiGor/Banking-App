import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BankApp {
    protected static String acc_name;
    protected static int acc_number;
    protected static String acc_type;
    protected static long acc_balance;
    protected static ArrayList<String> transactionHistory;

   
    public BankApp(String acc_name, String acc_type, long acc_balance, int acc_number) {
        this.acc_name = acc_name;
        this.acc_balance = acc_balance;
        this.acc_type = acc_type;
        this.acc_number = acc_number;
        this.transactionHistory = new ArrayList<>();
    }
    
    Account account = new Account(acc_number, acc_type, acc_name, acc_balance);

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Operations");
        while (true) {
            System.out.println("1. Open Account");
            System.out.println("2. Add Money");
            System.out.println("3. View Account Information");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // BankApp[] user = BankApp[];
                    OpenAccount.OpenAccount();
                    break;
                case 2:
                    AddTransaction add = new AddMoney();
                    add.AddMoney();
                    break;
                case 3:
                    ViewAccountInfo.ViewAccountInfo();
                    break;

                case 4:
                    WithdrawTransaction reduce = new WithdrawMoney();
                    reduce.WithdrawMoney();
                    break;
                case 5:
                    Transaction.transactionHistory();

                case 6:
                    System.exit(0);
                    break;
            }
        }
    }

}
