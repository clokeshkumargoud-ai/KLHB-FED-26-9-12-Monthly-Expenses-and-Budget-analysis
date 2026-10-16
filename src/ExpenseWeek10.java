/** Week 10: report clear errors for invalid fictional expense amounts. */
public class ExpenseWeek10 {
    public static void main(String[] args) {
        String[] sampleAmounts = {"500", "-1", "abc"};

        for (String sampleAmount : sampleAmounts) {
            try {
                double amount = parsePositiveAmount(sampleAmount);
                System.out.printf("Accepted amount: Rs. %.2f%n", amount);
            } catch (InvalidExpenseException exception) {
                System.out.printf("Rejected amount '%s': %s%n", sampleAmount, exception.getMessage());
            }
        }
    }

    static double parsePositiveAmount(String text) throws InvalidExpenseException {
        try {
            double amount = Double.parseDouble(text);
            if (amount <= 0) {
                throw new InvalidExpenseException("Amount must be greater than zero.");
            }
            return amount;
        } catch (NumberFormatException exception) {
            throw new InvalidExpenseException("Amount must be numeric.");
        }
    }

    static class InvalidExpenseException extends Exception {
        InvalidExpenseException(String message) {
            super(message);
        }
    }
}
