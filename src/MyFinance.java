import java.util.Scanner;

public class MyFinance {

    static Scanner sc = new Scanner(System.in);

    // Account Details
    static String name = "";
    static String username = "";
    static String password = "";
    static boolean accountCreated = false;

    // Income and Expenses
    static double income = 0;
    static double expenses = 0;

    // Store Income Details
    static double[] incomeList = new double[100];
    static int incomeCount = 0;

    // Store Expense Details
    static String[] transactionNames = new String[100];
    static String[] categories = new String[100];
    static double[] amounts = new double[100];
    static int expenseCount = 0;

    // Budget Management
    static double budget = 0;

    // Savings Goals
    static String goal = "";
    static double target = 0;
    static double saved = 0;

    // Main Method
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== MYFINANCE =====");
            System.out.println("1. Signup");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    signup();
                    break;

                case 2:
                    login();
                    break;

                case 3:
                    System.out.println("Thank You!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // 1. SIGNUP
    static void signup() {

        System.out.println("\n===== SIGNUP =====");

        if (accountCreated) {
            System.out.println("Account already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Create Username: ");
        username = sc.nextLine();

        System.out.print("Create Password: ");
        password = sc.nextLine();

        accountCreated = true;

        System.out.println("Account Created Successfully!");
    }

    // 2. LOGIN
    static void login() {

        if (!accountCreated) {
            System.out.println("Please signup first!");
            return;
        }

        System.out.println("\n===== LOGIN =====");

        System.out.print("Enter Username: ");
        String user = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        if (user.equals(username) && pass.equals(password)) {

            System.out.println("Login Successful!");

            dashboard();

        } else {

            System.out.println("Invalid Username or Password!");
        }
    }

    // 3. DASHBOARD
    static void dashboard() {

        int choice = 0;

        while (choice != 12) {

            System.out.println("\n===== MYFINANCE DASHBOARD =====");
            System.out.println("Welcome, " + name);

            System.out.println("Balance: Rs. " + (income - expenses));
            System.out.println("Income: Rs. " + income);
            System.out.println("Expenses: Rs. " + expenses);
            System.out.println("Savings Goal Amount: Rs. " + saved);

            System.out.println("\n1. Income Management");
            System.out.println("2. Expense Management");
            System.out.println("3. Transactions");
            System.out.println("4. Categories");
            System.out.println("5. Budget Management");
            System.out.println("6. Savings Goals");
            System.out.println("7. Reports");
            System.out.println("8. Profile");
            System.out.println("9. Account Settings");
            System.out.println("10. Search Transactions");
            System.out.println("11. View Balance");
            System.out.println("12. Logout");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    incomeManagement();
                    break;

                case 2:
                    expenseManagement();
                    break;

                case 3:
                    transactions();
                    break;

                case 4:
                    viewCategories();
                    break;

                case 5:
                    budgetManagement();
                    break;

                case 6:
                    savingsGoals();
                    break;

                case 7:
                    reports();
                    break;

                case 8:
                    profile();
                    break;

                case 9:
                    accountSettings();
                    break;

                case 10:
                    searchTransactions();
                    break;

                case 11:
                    System.out.println("Balance: Rs. " + (income - expenses));
                    break;

                case 12:
                    System.out.println("Logged out successfully!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

            if (!accountCreated) {
                return;
            }
        }
    }

    // 4. INCOME MANAGEMENT
    static void incomeManagement() {

        System.out.println("\n===== INCOME MANAGEMENT =====");

        System.out.println("1. Add Income");
        System.out.println("2. Edit Income");
        System.out.println("3. Delete Income");
        System.out.println("4. View Income");

        int choice = sc.nextInt();

        if (choice == 1) {

            if (incomeCount == 100) {
                System.out.println("Income storage full!");
                return;
            }

            System.out.print("Enter Income Amount: ");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid amount!");
                return;
            }

            incomeList[incomeCount] = amount;
            incomeCount++;

            income = income + amount;

            System.out.println("Income Added!");

        } else if (choice == 2) {

            viewIncome();

            System.out.print("Enter Income Number: ");
            int number = sc.nextInt();

            if (number >= 1 && number <= incomeCount) {

                System.out.print("Enter New Amount: ");
                double newAmount = sc.nextDouble();

                if (newAmount <= 0) {
                    System.out.println("Invalid amount!");
                    return;
                }

                income = income - incomeList[number - 1];

                incomeList[number - 1] = newAmount;

                income = income + newAmount;

                System.out.println("Income Updated!");

            } else {
                System.out.println("Invalid Number!");
            }

        } else if (choice == 3) {

            viewIncome();

            System.out.print("Enter Income Number: ");
            int number = sc.nextInt();

            if (number >= 1 && number <= incomeCount) {

                income = income - incomeList[number - 1];

                for (int i = number - 1; i < incomeCount - 1; i++) {
                    incomeList[i] = incomeList[i + 1];
                }

                incomeCount--;

                System.out.println("Income Deleted!");

            } else {
                System.out.println("Invalid Number!");
            }

        } else if (choice == 4) {

            viewIncome();

        } else {

            System.out.println("Invalid Choice!");
        }
    }

    static void viewIncome() {

        System.out.println("\n===== INCOME LIST =====");

        for (int i = 0; i < incomeCount; i++) {

            System.out.println((i + 1) + ". Rs. " + incomeList[i]);
        }

        System.out.println("Total Income: Rs. " + income);
    }

    // 5. EXPENSE MANAGEMENT
    static void expenseManagement() {

        System.out.println("\n===== EXPENSE MANAGEMENT =====");

        System.out.println("1. Add Expense");
        System.out.println("2. Edit Expense");
        System.out.println("3. Delete Expense");
        System.out.println("4. View Expenses");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {

            if (expenseCount == 100) {
                System.out.println("Expense storage full!");
                return;
            }

            System.out.print("Enter Expense Name: ");
            String transactionName = sc.nextLine();

            System.out.print("Enter Category: ");
            String category = sc.nextLine();

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid amount!");
                return;
            }

            transactionNames[expenseCount] = transactionName;
            categories[expenseCount] = category;
            amounts[expenseCount] = amount;

            expenseCount++;

            expenses = expenses + amount;

            System.out.println("Expense Added!");

        } else if (choice == 2) {

            viewExpenses();

            System.out.print("Enter Expense Number: ");
            int number = sc.nextInt();

            if (number >= 1 && number <= expenseCount) {

                System.out.print("Enter New Amount: ");
                double newAmount = sc.nextDouble();

                if (newAmount <= 0) {
                    System.out.println("Invalid amount!");
                    return;
                }

                expenses = expenses - amounts[number - 1];

                amounts[number - 1] = newAmount;

                expenses = expenses + newAmount;

                System.out.println("Expense Updated!");

            } else {
                System.out.println("Invalid Number!");
            }

        } else if (choice == 3) {

            viewExpenses();

            System.out.print("Enter Expense Number: ");
            int number = sc.nextInt();

            if (number >= 1 && number <= expenseCount) {

                expenses = expenses - amounts[number - 1];

                for (int i = number - 1; i < expenseCount - 1; i++) {

                    transactionNames[i] = transactionNames[i + 1];
                    categories[i] = categories[i + 1];
                    amounts[i] = amounts[i + 1];
                }

                expenseCount--;

                System.out.println("Expense Deleted!");

            } else {
                System.out.println("Invalid Number!");
            }

        } else if (choice == 4) {

            viewExpenses();

        } else {

            System.out.println("Invalid Choice!");
        }
    }

    static void viewExpenses() {

        System.out.println("\n===== EXPENSE LIST =====");

        for (int i = 0; i < expenseCount; i++) {

            System.out.println((i + 1) + ". " +
                    transactionNames[i] + " - " +
                    categories[i] + " - Rs. " +
                    amounts[i]);
        }

        System.out.println("Total Expenses: Rs. " + expenses);
    }

    // 6. TRANSACTIONS
    static void transactions() {

        System.out.println("\n===== TRANSACTIONS =====");

        System.out.println("1. View History");
        System.out.println("2. Search Transaction");
        System.out.println("3. Filter by Category");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {

            viewExpenses();

        } else if (choice == 2) {

            searchTransactions();

        } else if (choice == 3) {

            System.out.print("Enter Category: ");
            String search = sc.nextLine();

            boolean found = false;

            for (int i = 0; i < expenseCount; i++) {

                if (categories[i].equalsIgnoreCase(search)) {

                    System.out.println(transactionNames[i] +
                            " - Rs. " + amounts[i]);

                    found = true;
                }
            }

            if (!found) {
                System.out.println("No transactions found!");
            }

        } else {

            System.out.println("Invalid Choice!");
        }
    }

    // 7. CATEGORIES
    static void viewCategories() {

        System.out.println("\n===== CATEGORIES =====");

        System.out.println("1. Food");
        System.out.println("2. Travel");
        System.out.println("3. Shopping");
        System.out.println("4. Bills");
        System.out.println("5. Others");
    }

    // 8. BUDGET MANAGEMENT
    static void budgetManagement() {

        System.out.println("\n1. Set Budget");
        System.out.println("2. View Budget");
        System.out.println("3. Reset Budget");

        int choice = sc.nextInt();

        if (choice == 1) {

            System.out.print("Enter budget: ");
            double newBudget = sc.nextDouble();

            if (newBudget >= 0) {
                budget = newBudget;
                System.out.println("Budget saved!");
            } else {
                System.out.println("Invalid budget!");
            }

        } else if (choice == 2) {

            System.out.println("Your budget: Rs. " + budget);
            System.out.println("Remaining Budget: Rs. " + (budget - expenses));

        } else if (choice == 3) {

            budget = 0;
            System.out.println("Budget reset!");

        } else {

            System.out.println("Invalid choice!");
        }
    }

    // 9. SAVINGS GOALS
    static void savingsGoals() {

        System.out.println("\n1. Create Goal");
        System.out.println("2. View Goal");
        System.out.println("3. Update Saved Amount");
        System.out.println("4. Delete Goal");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {

            System.out.print("Enter goal name: ");
            goal = sc.nextLine();

            System.out.print("Enter target amount: ");
            target = sc.nextDouble();

            System.out.print("Enter amount saved: ");
            saved = sc.nextDouble();

            System.out.println("Goal created!");

        } else if (choice == 2) {

            System.out.println("Goal: " + goal);
            System.out.println("Target: Rs. " + target);
            System.out.println("Saved: Rs. " + saved);
            System.out.println("Remaining: Rs. " + (target - saved));

        } else if (choice == 3) {

            System.out.print("Enter new saved amount: ");
            saved = sc.nextDouble();

            System.out.println("Goal updated!");

        } else if (choice == 4) {

            goal = "";
            target = 0;
            saved = 0;

            System.out.println("Goal deleted!");

        } else {

            System.out.println("Invalid choice!");
        }
    }

    // 10. REPORTS
    static void reports() {

        System.out.println("\n===== REPORTS =====");

        System.out.println("Total Income: Rs. " + income);
        System.out.println("Total Expenses: Rs. " + expenses);
        System.out.println("Savings: Rs. " + (income - expenses));
        System.out.println("Budget: Rs. " + budget);
        System.out.println("Remaining Budget: Rs. " + (budget - expenses));

        System.out.println("\n===== CATEGORY-WISE EXPENSES =====");

        String[] categoryNames = {
                "Food", "Travel", "Shopping", "Bills", "Others"
        };

        for (String categoryName : categoryNames) {

            double total = 0;

            for (int i = 0; i < expenseCount; i++) {

                if (categories[i].equalsIgnoreCase(categoryName)) {

                    total = total + amounts[i];
                }
            }

            System.out.println(categoryName + ": Rs. " + total);
        }
    }

    // 11. PROFILE
    static void profile() {

        System.out.println("\nName: " + name);
        System.out.println("Username: " + username);

        System.out.print("Enter new name: ");
        String newName = sc.nextLine();

        if (!newName.isEmpty()) {

            name = newName;

            System.out.println("Profile updated!");
        }
    }

    // 12. ACCOUNT SETTINGS
    static void accountSettings() {

        System.out.println("\n1. Change Password");
        System.out.println("2. Delete Account");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {

            System.out.print("Enter current password: ");
            String oldPassword = sc.nextLine();

            if (oldPassword.equals(password)) {

                System.out.print("Enter new password: ");
                password = sc.nextLine();

                System.out.println("Password changed!");

            } else {

                System.out.println("Incorrect password!");
            }

        } else if (choice == 2) {

            System.out.print("Enter password: ");
            String pass = sc.nextLine();

            if (pass.equals(password)) {

                name = "";
                username = "";
                password = "";

                accountCreated = false;

                income = 0;
                expenses = 0;
                budget = 0;

                goal = "";
                target = 0;
                saved = 0;

                incomeCount = 0;
                expenseCount = 0;

                System.out.println("Account details deleted!");

            } else {

                System.out.println("Incorrect password!");
            }
        }
    }

    // 13. SEARCH TRANSACTIONS
    static void searchTransactions() {

        System.out.print("Enter transaction name or category: ");
        String search = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < expenseCount; i++) {

            if (transactionNames[i].equalsIgnoreCase(search)
                    || categories[i].equalsIgnoreCase(search)) {

                System.out.println("Transaction: " + transactionNames[i]);
                System.out.println("Category: " + categories[i]);
                System.out.println("Amount: Rs. " + amounts[i]);

                found = true;
            }
        }

        if (!found) {

            System.out.println("Transaction not found!");
        }
    }
}