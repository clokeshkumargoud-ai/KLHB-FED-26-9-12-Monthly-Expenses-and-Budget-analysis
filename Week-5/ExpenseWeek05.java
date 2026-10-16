/** Week 5: reuse methods for a fixed fictional budget calculation. */
public class ExpenseWeek05 {
    public static void main(String[] args) {
        double budget = 30000.00;
        double[] expenses = {12000.00, 5500.00, 2200.00, 1800.00, 1500.00};
        double total = sumExpenses(expenses);
        double remaining = remainingBudget(budget, total);

        System.out.println("Method total: " + formatMoney(total));
        System.out.println("Method remaining: " + formatMoney(remaining));
        System.out.println("Status: " + (remaining >= 0 ? "within budget." : "over budget."));
    }

    static double sumExpenses(double[] expenses) {
        double total = 0.00;
        for (double expense : expenses) {
            total += expense;
        }
        return total;
    }

    static double remainingBudget(double budget, double total) {
        return budget - total;
    }

    static String formatMoney(double amount) {
        return String.format("Rs. %.2f", amount);
    }
}
