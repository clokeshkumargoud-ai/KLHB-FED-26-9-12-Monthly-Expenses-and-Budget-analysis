/** Week 6: search fictional expense categories stored in parallel arrays. */
public class ExpenseWeek06 {
    public static void main(String[] args) {
        String[] categories = {"Rent", "Groceries", "Utilities", "Transport", "Learning"};
        double[] amounts = {12000.00, 5500.00, 2200.00, 1800.00, 1500.00};
        int utilitiesIndex = findCategory(categories, "Utilities");
        int largestIndex = findLargest(amounts);

        System.out.printf("Search Utilities -> Rs. %.2f%n", amounts[utilitiesIndex]);
        System.out.printf("Largest expense: %s (Rs. %.2f)%n", categories[largestIndex], amounts[largestIndex]);
        System.out.println("Categories stored: " + categories.length);
    }

    static int findCategory(String[] categories, String target) {
        for (int index = 0; index < categories.length; index++) {
            if (categories[index].equalsIgnoreCase(target)) {
                return index;
            }
        }
        return -1;
    }

    static int findLargest(double[] amounts) {
        int largestIndex = 0;
        for (int index = 1; index < amounts.length; index++) {
            if (amounts[index] > amounts[largestIndex]) {
                largestIndex = index;
            }
        }
        return largestIndex;
    }
}
