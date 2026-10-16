import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/** Week 11: write and reload a small fictional expense CSV. */
public class ExpenseWeek11 {
    public static void main(String[] args) throws IOException {
        Path file = Path.of("expenses.csv");
        List<String> records = List.of(
                "date,category,amount",
                "2026-08-01,Rent,12000",
                "2026-08-02,Groceries,5500",
                "2026-08-03,Utilities,2200");
        Files.write(file, records, StandardCharsets.UTF_8);

        List<String> loaded = Files.readAllLines(file, StandardCharsets.UTF_8);
        int subtotal = 0;
        for (int index = 1; index < loaded.size(); index++) {
            subtotal += Integer.parseInt(loaded.get(index).split(",")[2]);
        }

        System.out.println("Saved 3 expense records to expenses.csv");
        System.out.println("Loaded expense records: " + (loaded.size() - 1));
        System.out.printf("File subtotal: Rs. %.2f%n", (double) subtotal);
    }
}
