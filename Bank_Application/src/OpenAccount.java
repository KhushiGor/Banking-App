import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class OpenAccount extends BankApp {
    public static List<String> Account = new ArrayList<>();
    // public OpenAccount(String acc_name, String acc_type, long acc_balance, int
    // acc_number) {
    // super.acc_name = acc_name;
    // super.acc_number = acc_number;
    // super.acc_type= acc_type;
    // super.acc_balance=acc_balance;

    // }

    public static void OpenAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Details:");
        // BankApp[] user = new BankApp[3];
        System.out.print("Enter name:");
        acc_name = sc.next();

        System.out.print("Enter Account type Savings or Current:");
        acc_type = sc.next();
        System.out.print("Enter Account initial balance Amount:");
        acc_balance = sc.nextLong();
        //
        // user[0]=new
        // user(newuser.acc_name,newuser.acc_balance,newuser.acc_type,newuser.acc_number);
        // user[0] = newuser;
        System.out.println(" ");
        Random rn = new Random();
        acc_number = rn.nextInt(100000);
        BankApp newuser = new BankApp(acc_name, acc_type, acc_balance, acc_number);
        Account.add(newuser);
        System.out.println("Your Account Number is :" + acc_number);
        System.out.println("Account Created Sucessfully...!!!");
        // System.out.println("Entered details:" + user[0].acc_name);
        // System.out.println(user[0].acc_type);
        // System.out.println(user[0].acc_balance);

    }

}