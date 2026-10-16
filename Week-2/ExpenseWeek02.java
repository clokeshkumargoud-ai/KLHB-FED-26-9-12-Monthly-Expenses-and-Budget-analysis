/** Week 2: validate fixed fictional expense values before accepting them. */
public class ExpenseWeek02 {
    public static void main(String[] args) {
        printExpenseResult("Groceries", 5500.00);
        printExpenseResult("Transport", 0.00);
        printExpenseResult("", 500.00);
    }

    static void printExpenseResult(String category, double amount) {
        if (category.isBlank()) {
            System.out.println("Rejected category: category is required.");
        } else if (amount <= 0) {
            System.out.println("Rejected expense: amount must be greater than zero.");
        } else {
            System.out.printf("Accepted expense: %s Rs. %.2f%n", category, amount);
        }
    }
}
