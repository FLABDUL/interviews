package addepar;

import java.util.*;

public class PortfolioReconciliationSolution {

    public static List<String> reconcile(String[] initial, String[] function, String[] end) {
        // Step 1: Parse initial portfolio into a map
        Map<String, Integer> portfolio = new HashMap<>();

        // Parse the initial portfolio
        for (String item : initial) {
            String[] parts = item.split(" ");
            String symbol = parts[0];
            int quantity = Integer.parseInt(parts[1]);
            portfolio.put(symbol, quantity);
        }

        // Step 2: Process the transactions
        for (String transaction : function) {
            String[] parts = transaction.split(" ");
            String symbol = parts[0];
            String action = parts[1];  // "BY" or "SL"
            int quantity = Integer.parseInt(parts[2]);
            int price = Integer.parseInt(parts[3]);

            if (action.equals("BY")) {
                // Buying: Decrease cash and increase stock
                int totalCost = quantity * price;
                portfolio.put("Cash", portfolio.get("Cash") - totalCost);
                portfolio.put(symbol, portfolio.getOrDefault(symbol, 0) + quantity);
            } else if (action.equals("SL")) {
                // Selling: Increase cash and decrease stock
                int totalRevenue = quantity * price;
                portfolio.put("Cash", portfolio.get("Cash") + totalRevenue);
                portfolio.put(symbol, portfolio.getOrDefault(symbol, 0) - quantity);
            }
        }

        // Step 3: Compare the final portfolio with the expected portfolio (end)
        Map<String, Integer> endPortfolio = new HashMap<>();

        // Parse the end portfolio
        for (String item : end) {
            String[] parts = item.split(" ");
            String symbol = parts[0];
            int quantity = Integer.parseInt(parts[1]);
            endPortfolio.put(symbol, quantity);
        }

        // Step 4: Find the differences
        List<String> result = new ArrayList<>();

        for (String symbol : endPortfolio.keySet()) {
            int expectedQuantity = endPortfolio.get(symbol);
            int actualQuantity = portfolio.getOrDefault(symbol, 0);
            int difference = actualQuantity - expectedQuantity;

            if (difference != 0) {
                result.add(symbol + " " + difference);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        // Test case 1:
        String[] initial = {"AAPL 50", "TSLA 4", "Cash 10000"};
        String[] function = {"AAPL BY 50 2", "TSLA SL 2 3"};
        String[] end = {"AAPL 100", "TSLA 2", "Cash 9994"};

        List<String> expected = Arrays.asList("Cash -4");
        List<String> result = reconcile(initial, function, end);

        if (expected.equals(result)) {
            System.out.println("✅ Test Passed!");
        } else {
            System.out.println("❌ Test Failed!");
            System.out.println("Expected: " + expected);
            System.out.println("Got     : " + result);
        }
    }
}
