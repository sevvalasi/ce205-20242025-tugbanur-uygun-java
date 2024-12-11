package com.sevval.tugba.naz.irem.market;

public class OverflowEntry {

	private int key;
    private boolean isOccupied;

    public OverflowEntry() {
        this.key = -1;
        this.isOccupied = false;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
	
}
