package lmr.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Aggregator {
    //setup portfolio of trades
    Map<Integer, Set<Trade>> portfolio = new HashMap<>();

    //manual aggregate method
        //values needed
        //get trade set
        //check null so add
        //else add new portfolio
    void addTradeOptimised(Trade trade){
        int systemId = trade.getSystemId();
        portfolio.computeIfAbsent(systemId, k -> new HashSet<>()).add(trade);
    }

    //improved aggregate method
    //computer if absent
    void addTrade(Trade trade){
        int systemId = trade.getSystemId();
        if(portfolio.get(systemId) != null) {//exists
            portfolio.get(systemId).add(trade);
        }else{
            portfolio.put(systemId, new HashSet<>());
        }
    }

    //modify trade manual loop
        //get systemid and trades set
        //if null reutrn null
        //old trade create
        //find it via loop and if statement
        //if oldtrade found exists
        //remove from trades
        //add new one
        //return oldone
    Trade modifyTrade(Trade trade){
        int systemId = trade.getSystemId();
        if(portfolio.get(systemId) == null){
            return null;
        }else{
            Trade oldTrade = null;
            for(Trade pmTrade : portfolio.get(systemId)){
                if(pmTrade.getTradeId().equals(trade.getTradeId())){
                    oldTrade = pmTrade;
                    portfolio.get(systemId).remove(oldTrade);
                    portfolio.get(systemId).add(trade);
                    return oldTrade;
                }
            }
            return null;
        }
    }


    //stream style trade modify
        //get old trade by filtering

        //if oldtrde exists
        //remvoe it
        //if now empty
            //remove id too form pm
        //then reaggregate
    Trade modifyTradeStream(Trade trade){
        Trade oldTrade = portfolio.values()//set trades
                .stream()//stream set trades
                .flatMap(Set::stream)//stream of trades
                .filter(t -> t.getTradeId().equals(trade.getTradeId()))//filter by tradeId
                .findFirst()//get first result
                .orElse(null);//could be null

        if(oldTrade != null){
            portfolio.get(trade.getSystemId()).remove(oldTrade);//remove value
            if(portfolio.get(trade.getSystemId()).isEmpty()){
                portfolio.remove(oldTrade.getSystemId());//remove key
            }
            addTrade(trade);
            return oldTrade;
        }
        return null;
    }

    double sumPortfolio(int systemId){
        Set<Trade> trades = portfolio.get(systemId);
        if(trades == null){
            return 0;
        }
        double sum = 0.00;
        for(Trade trade : trades){
            sum += trade.getQuantity();
        }
        return sum;
    }

    double sumPortfolioSafe(int systemId){
        return portfolio.getOrDefault(systemId, Set.of())
                .stream()
                .mapToDouble(Trade::getQuantity)
                .sum();
    }
}
