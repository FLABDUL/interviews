package addepar;

import java.util.*;

public class PortfolioReconciliation {

    public static List<String> reconcile(String[] initial, String[] function, String[] end) {
        // TODO: Implement your reconciliation logic here

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        testReconcile();
    }

    public static void testReconcile() {
        String[] initial = {"AAPL 50", "TSLA 4", "Cash 10000"};
        String[] function = {"AAPL BY 50 2", "TSLA SL 2 3"};
        String[] end = {"AAPL 100", "TSLA 2", "Cash 9994"};

        List<String> expected = Arrays.asList("Cash -4");

        List<String> result = reconcile(initial, function, end);

//        assert result.equals(null) : "Test failed! Expected " + expected + " but got " + result;

//        System.out.println("Test passed!");
        if (expected.equals(result)) {
            System.out.println("✅ Test Passed!");
        } else {
            System.out.println("❌ Test Failed!");
            System.out.println("Expected: " + expected);
            System.out.println("Got     : " + result);
        }
    }
}
