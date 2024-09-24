public class ViewAccountInfo extends BankApp {

    public static void ViewAccountInfo() {
        ViewAccountInfo user = new ViewAccountInfo();

        // user= super.user;
        System.out.println("user Name:" + user.acc_name);
        System.out.println("Account Number :" + user.acc_number);
        System.out.println("Account Type:" + user.acc_type);
        System.out.println("Available Balance:" + user.acc_balance);
        // }
    }

    // public String getAcc_name() {
    // return acc_name;
    // }
}
