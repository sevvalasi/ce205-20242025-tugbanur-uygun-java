package com.sevval.tugba.naz.irem.market;

public class XORNode {
	MarketHours data;
    XORNode both; // XOR of previous and next nodes

    public XORNode(MarketHours data) {
        this.data = data;
        this.both = null;
    }

}
