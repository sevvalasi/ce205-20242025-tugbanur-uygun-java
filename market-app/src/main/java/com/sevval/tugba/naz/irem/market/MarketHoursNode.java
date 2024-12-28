package com.sevval.tugba.naz.irem.market;

public class MarketHoursNode {
    MarketHours data;
    MarketHoursNode xorPtr;

    public MarketHoursNode(MarketHours data) {
        this.data = data;
    }

    public MarketHoursNode(int xorHash) {
        // Placeholder constructor for XOR operation, does nothing meaningful
    }
}
