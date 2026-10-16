/** Week 9: represent a fictional expense and budget report with classes. */
public class ExpenseWeek09 {
    public static void main(String[] args) {
        Expense rent = new Expense("Rent", 12000.00);
        BudgetReport report = new BudgetReport(30000.00, 23000.00, rent);

        System.out.printf("Report budget: Rs. %.2f%n", report.getBudget());
        System.out.printf("Report total: Rs. %.2f%n", report.getTotal());
        System.out.printf("Highest category: %s (Rs. %.2f)%n",
                report.getHighest().getCategory(), report.getHighest().getAmount());
    }

    static class Expense {
        private final String category;
        private final double amount;

        Expense(String category, double amount) {
            this.category = category;
            this.amount = amount;
        }

        String getCategory() {
            return category;
        }

        double getAmount() {
            return amount;
        }
    }

    static class BudgetReport {
        private final double budget;
        private final double total;
        private final Expense highest;

        BudgetReport(double budget, double total, Expense highest) {
            this.budget = budget;
            this.total = total;
            this.highest = highest;
        }

        double getBudget() {
            return budget;
        }

        double getTotal() {
            return total;
        }

        Expense getHighest() {
            return highest;
        }
    }
}
