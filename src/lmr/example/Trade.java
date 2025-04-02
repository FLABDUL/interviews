package lmr.example;

import java.util.Objects;

public class Trade {
    private final String tradeId;
    private final int systemId;
    private final double quantity;

    public Trade(String tradeId, int systemId, double quantity) {
        this.tradeId = tradeId;
        this.systemId = systemId;
        this.quantity = quantity;
    }

    public String getTradeId() {
        return tradeId;
    }

    public int getSystemId() {
        return systemId;
    }

    public double getQuantity() {
        return quantity;
    }

    public String toString() {
        return "Trade{" +
                "tradeId='" + tradeId + '\'' +
                ", systemId=" + systemId +
                ", quantity=" + quantity +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trade trade = (Trade) o;
        return systemId == trade.systemId && Double.compare(quantity, trade.quantity) == 0 && Objects.equals(tradeId, trade.tradeId);
    }

    public int hashCode() {
        return Objects.hash(tradeId, systemId, quantity);
    }

}
