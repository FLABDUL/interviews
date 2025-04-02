package lmr.answer;

import lmr.example.Trade;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Aggregator {
    private final Map<Integer, Set<Trade>> portfolio = new HashMap<>();//systemId, Trade

    public void aggregate(Trade trade){
        String tradeId = trade.getTradeId();
        double quantity = trade.getQuantity();
        int systemId = trade.getSystemId();//key

        Set<Trade> trades = portfolio.get(systemId);

        if(trades != null){//portfolio exists
            trades.add(trade);
        }else{//doesnt exist
//            Set<Trade> set = new HashSet<>();//fastest approach
//            set.add(trade);
            Set<Trade> set = new HashSet<>(Set.of());//slower since immutable firs then copies
            set.add(trade);
            portfolio.put(systemId, set);
        }
    }

    public void aggregateImproved(Trade trade) {
        portfolio.computeIfAbsent(trade.getSystemId(), k -> new HashSet<>()).add(trade);
    }//checks if systemid exists in pm, if exists retrieve trades, else create new set, then adds trade to it


    public Trade modifyTradeLoop(Trade trade) {
        int systemId = trade.getSystemId();
        Set<Trade> trades = portfolio.get(systemId);

        if (trades == null) {
            return null; // No trades exist for this systemId
        }

        Trade oldTrade = null;

        // Find the trade with the same tradeId
        for (Trade t : trades) {
            if (t.getTradeId().equals(trade.getTradeId())) {
                oldTrade = t;
                break; // Stop loop once found
            }
        }

        if (oldTrade != null) {
            trades.remove(oldTrade); // Remove old trade
            trades.add(trade);       // Add the updated trade
            return oldTrade;         // Return the removed trade
        }

        return null; // Trade not found
    }


    public Trade modifyTradeStream(Trade trade){//assuming tradeId is key
        Trade oldTrade = portfolio.values().stream()
                .flatMap(Set::stream)
                .filter(t -> t.getTradeId().equals(trade.getTradeId()))
                .findFirst()
                .orElse(null);

        if (oldTrade != null) {
            portfolio.get(oldTrade.getSystemId()).remove(oldTrade);//remove trade
            if (portfolio.get(oldTrade.getSystemId()).isEmpty()) {//if set is now empty
                portfolio.remove(oldTrade.getSystemId());//remove id as well to prevent empty trade sets
            }
            aggregate(trade);
            return oldTrade;
        }
        return null;
    }

    public double sumPortfolio(int systemId) {//one pm
        Set<Trade> trades = portfolio.get(systemId);
        if(trades == null){
            return 0;
        }
        return trades.stream().mapToDouble(Trade::getQuantity).sum();
    }

    public double sumPortfolioSafe(int systemId) {
        return portfolio.getOrDefault(systemId, Set.of()).stream()
                .mapToDouble(Trade::getQuantity)
                .sum();
    }

}
