/** Week 3: calculate a fixed fictional expense total and budget status. */
public class ExpenseWeek03 {
    public static void main(String[] args) {
        double budget = 30000.00;
        double totalExpenses = 12000.00 + 5500.00 + 2200.00 + 1800.00 + 1500.00;
        double remaining = budget - totalExpenses;

        System.out.printf("Total expenses: Rs. %.2f%n", totalExpenses);
        System.out.printf("Remaining budget: Rs. %.2f%n", remaining);
        System.out.println("Budget status: " + (remaining >= 0 ? "within budget." : "over budget."));
    }
}
