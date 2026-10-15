import java.util.Scanner;

public class BankLedger {

    static Scanner sc = new Scanner(System.in);

    static String name;
    static String accountNumber;

    static double balance = 0;
    static double deposits = 0;
    static double withdrawals = 0;

    static String lastTransaction = "No transactions";
    static double lastAmount = 0;

    public static void main(String[] args) {

        System.out.println("===== PERSONAL BANK LEDGER =====");

        System.out.print("Enter your name: ");
        name = sc.nextLine();

        System.out.print("Enter account number: ");
        accountNumber = sc.nextLine();

        while (true) {

            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Dashboard");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Ledger");
            System.out.println("5. Bank Statement");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    dashboard();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    ledger();
                    break;

                case 5:
                    statement();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // DASHBOARD
    static void dashboard() {

        System.out.println("\n===== DASHBOARD =====");
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: Rs. " + balance);
    }

    // DEPOSIT
    static void deposit(){

        System.out.print("Enter deposit amount: ");
        double amount = sc.nextDouble();

        if (amount > 0) {

            balance = balance + amount;
            deposits = deposits + amount;

            lastTransaction = "Deposit";
            lastAmount = amount;

            System.out.println("Deposit successful!");

        } else {

            System.out.println("Invalid amount!");
        }
    }

    // WITHDRAW
    static void withdraw() {

        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {

            System.out.println("Invalid amount!");

        } else if (amount > balance) {

            System.out.println("Insufficient balance!");

        } else {

            balance = balance - amount;
            withdrawals = withdrawals + amount;

            lastTransaction = "Withdrawal";
            lastAmount = amount;

            System.out.println("Withdrawal successful!");
        }
    }

    // LEDGER
    static void ledger(){

        System.out.println("\n===== BANK LEDGER =====");
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + accountNumber);

        System.out.println("-------------------------");
        System.out.println("Last Transaction: " + lastTransaction);
        System.out.println("Transaction Amount: Rs. " + lastAmount);
        System.out.println("Current Balance: Rs. " + balance);
        System.out.println("-------------------------");
    }

    // BANK STATEMENT
    static void statement() {

        System.out.println("\n===== BANK STATEMENT =====");

        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + accountNumber);

        System.out.println("Total Deposits: Rs. " + deposits);
        System.out.println("Total Withdrawals: Rs. " + withdrawals);
        System.out.println("Current Balance: Rs. " + balance);
    }
}
