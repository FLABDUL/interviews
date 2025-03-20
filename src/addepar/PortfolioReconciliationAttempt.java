package addepar;

import java.util.*;

public class PortfolioReconciliationAttempt {

    public static List<String> reconcile(String[] initial, String[] function, String[] end) {
        // TODO: Implement your reconciliation logic here
        //create hashmap each account for stock and cash
        //cycel through initial elements
        //check against hashmap existence and update value
        Map<String, Integer> positions = new HashMap<>();
        for(String item : initial){
            //APPL 50
            String[] accountQuantity = item.split(" ");
            String account = accountQuantity[0];
            int quantity = Integer.parseInt(accountQuantity[1]);
            positions.put(account, quantity);
        }
        System.out.println("positions: " + positions);

        //cycle through function and assign values
        //take away from hashmap initials
        int cashChange = 0;
        for(String item : function){
            String[] accountFunctionQuantityPrice = item.split(" ");
            String account = accountFunctionQuantityPrice[0];
            String trade = accountFunctionQuantityPrice[1];
            int quantity = Integer.parseInt(accountFunctionQuantityPrice[2]);
            int tradeQuantity = 0;
            if(trade.equals("SL")){
                tradeQuantity = -quantity;
            }else{
                tradeQuantity = quantity;
            }
            int price = Integer.parseInt(accountFunctionQuantityPrice[3]);
            positions.put(account, positions.get(account) + tradeQuantity);
            cashChange += tradeQuantity*-price;
        }
        positions.put("Cash", positions.get("Cash")+cashChange);
        //create list string result
        //cycel through each end compare against initial
        //create stringbuilder for result
        //calcualte diff
        //if diff add to list
        System.out.println("updated positions: " + positions);

        List<String> result = new ArrayList<>();
        for(String item : end){
            StringBuilder element = new StringBuilder();
            String[] accountQuantity = item.split(" ");
            String account = accountQuantity[0];
            int quantity = Integer.parseInt(accountQuantity[1]);
            if(positions.get(account) != quantity){
                int quantityChange = quantity - positions.get(account);
                element.append(account).append(" ").append(quantityChange);
                System.out.println("element " + element.toString());
                result.add(String.valueOf(element));//use element.toString() instead!
            }
        }
        return result;
    }

    public static void main(String[] args) {
        testReconcile();
    }

    public static void testReconcile() {
        String[] initial = {"AAPL 50", "TSLA 4", "Cash 10000"};
        String[] function = {"AAPL BY 50 2", "TSLA SL 2 3"};
        String[] end = {"AAPL 100", "TSLA 2", "Cash 9902"};

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
