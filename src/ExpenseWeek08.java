/** Week 8: recursively total the fixed fictional expense list. */
public class ExpenseWeek08 {
    public static void main(String[] args) {
        int budget = 30000;
        int[] expenses = {12000, 5500, 2200, 1800, 1500};
        int total = sumExpenses(expenses, 0);

        System.out.println("Expenses reviewed: " + expenses.length);
        System.out.printf("Recursive total: Rs. %.2f%n", (double) total);
        System.out.printf("Recursive remaining: Rs. %.2f%n", (double) (budget - total));
    }

    static int sumExpenses(int[] expenses, int index) {
        if (index == expenses.length) {
            return 0;
        }
        return expenses[index] + sumExpenses(expenses, index + 1);
    }
}
