/** Week 4: process a fixed expense list using a menu-shaped while loop. */
public class ExpenseWeek04 {
    public static void main(String[] args) {
        double budget = 30000.00;
        double[] expenses = {12000.00, 5500.00, 2200.00, 1800.00, 1500.00};
        double total = 0.00;
        int index = 0;

        System.out.println("=== EXPENSE MENU ===");
        System.out.println("1. Review expenses");
        System.out.println("2. Check budget");

        while (index < expenses.length) {
            total += expenses[index];
            index++;
        }

        System.out.println("Expense entries processed: " + expenses.length);
        System.out.printf("Current remaining budget: Rs. %.2f%n", budget - total);
    }
}
