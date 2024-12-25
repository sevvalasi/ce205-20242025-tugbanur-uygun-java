package com.sevval.tugba.naz.irem.market;

public class HashTableEntry {
    private int key;
    private boolean isOccupied;

    public HashTableEntry() {
        this.key = -1;
        this.isOccupied = false;
    }

    public HashTableEntry(boolean isOccupied, int key) {
        this.isOccupied = isOccupied;
        this.key = key;
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

    @Override
    public String toString() {
        return "Key: " + key + ", Is Occupied: " + isOccupied;
    }
}
