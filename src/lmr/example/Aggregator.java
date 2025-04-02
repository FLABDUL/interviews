package lmr.example;//package org.example;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
//public class Aggregator {
////    private final Map<Integer, Double> portfolio = new HashMap<>();
//
//    private final Map<Integer, Set<Trade>> portfolio = new HashMap<>();//systemId, Trade
//
//    public void aggregate(Trade trade){
//        //keep track position sum of trades
//        //hashmap for pm system id, quantity
//        //getordefault
//        //update quantity
//
//        String tradeId = trade.getTradeId();
//        double quantity = trade.getQuantity();
//        int systemId = trade.getSystemId();//key
//
//        Set<Trade> trades = portfolio.get(systemId);
//
//        if(trades != null){//portfolio exists
//            trades.add(trade);
//        }else{//doesnt exist
//            Set<Trade> set = new HashSet<>();
//            set.add(trade);
//            portfolio.put(systemId, set);
//        }
//    }
//
//    public Trade modifyTrade(Trade trade){//assuming tradeId is key
//        String tradeId = trade.getTradeId();
//        double quantity = trade.getQuantity();
//        int systemId = trade.getSystemId();
//        //portfolio needed
//        //grab set trades
//        //look for it via tradeId
//        //update systemId, quantity
//        Set<Trade> trades = portfolio.get(systemId);
////        Trade potentiallyModTrade = trades.
//        for(Trade modTrade : trades){
//            if(modTrade.getTradeId().equals(trade.getTradeId())){//not the same!
//                portfolio.put(tradeId, )
//            }
//        }
////        portfolio.get(systemId);//exists
//
//        //presumption tradeId exists//
//        return null;
//    }
//
//    public double sumPortfolio(int systemId) {//one pm
//        //cycle trhoguh each systemId
//        //get trade set
//        //icnremendtally add quantiites together, //keep track sumquantity
//        //and return
//        Set<Trade> trades = portfolio.get(systemId);
//        if(trades == null){
//            return 0;
//        }
//        double sumQuantty = 0;
//        for(Trade trade : trades) {
//            double quantity = trade.getQuantity();
//            sumQuantty += quantity;
//        }
//        return sumQuantty;
//    }
//}
