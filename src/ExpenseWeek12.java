import java.util.List;

/**
 * Week 12 final report over fictional household data only.
 * It is a programming exercise, not financial advice.
 */
public class ExpenseBudgetAnalyzer {
    public static void main(String[] args) {
        int budget = 30000;
        List<Expense> expenses = List.of(
                new Expense("Rent", 12000),
                new Expense("Groceries", 5500),
                new Expense("Utilities", 2200),
                new Expense("Transport", 1800),
                new Expense("Learning", 1500));

        int total = expenses.stream().mapToInt(Expense::amount).sum();
        int remaining = budget - total;
        Expense largest = expenses.stream().max((first, second) -> Integer.compare(first.amount(), second.amount()))
                .orElseThrow();

        System.out.println("MONTHLY EXPENSE & BUDGET ANALYZER - FINAL RELEASE");
        System.out.printf("Budget: Rs. %.2f%n", (double) budget);
        System.out.printf("Total expenses: Rs. %.2f%n", (double) total);
        System.out.printf("Remaining: Rs. %.2f%n", (double) remaining);
        System.out.printf("Largest expense: %s (Rs. %.2f)%n", largest.category(), (double) largest.amount());
        System.out.println("Categories: " + expenses.stream().map(Expense::category).distinct().count());
        System.out.println("Budget status: " + (remaining >= 0 ? "within budget." : "over budget."));
    }

    static class Expense {
        private final String category;
        private final int amount;

        Expense(String category, int amount) {
            this.category = category;
            this.amount = amount;
        }

        String category() {
            return category;
        }

        int amount() {
            return amount;
        }
    }
}
