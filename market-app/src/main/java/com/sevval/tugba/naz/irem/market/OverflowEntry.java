package com.sevval.tugba.naz.irem.market;

public class OverflowEntry {
    private boolean isOccupied;
    private int key;

    public OverflowEntry() {
        this.isOccupied = false;
        this.key = -1;
    }

    public OverflowEntry(boolean isOccupied, int key) {
        this.isOccupied = isOccupied;
        this.key = key;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Key: " + key + ", Is Occupied: " + isOccupied;
    }
}
