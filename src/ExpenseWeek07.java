/** Week 7: handle valid and invalid entries in a fictional budget review. */
public class ExpenseWeek07 {
    public static void main(String[] args) {
        BudgetReview review = new BudgetReview(30000.00, 23000.00, 5);
        review.addExpense("Savings", 500.00);
        review.addExpense("Rent", -50.00);
        review.addExpense("Unknown", 200.00);
        System.out.println("Reviewed valid entries: " + review.getValidEntries());
        System.out.printf("Remaining after valid entry: Rs. %.2f%n", review.getRemaining());
    }

    static class BudgetReview {
        private final double budget;
        private double total;
        private int validEntries;

        BudgetReview(double budget, double total, int validEntries) {
            this.budget = budget;
            this.total = total;
            this.validEntries = validEntries;
        }

        void addExpense(String category, double amount) {
            if (amount < 0) {
                System.out.println("Rejected: negative expense.");
            } else if (!isKnownCategory(category)) {
                System.out.println("Rejected: unknown category.");
            } else {
                total += amount;
                validEntries++;
                System.out.printf("Added: %s Rs. %.2f%n", category, amount);
            }
        }

        boolean isKnownCategory(String category) {
            return category.equals("Rent") || category.equals("Groceries") || category.equals("Utilities")
                    || category.equals("Transport") || category.equals("Learning") || category.equals("Savings");
        }

        int getValidEntries() {
            return validEntries;
        }

        double getRemaining() {
            return budget - total;
        }
    }
}
