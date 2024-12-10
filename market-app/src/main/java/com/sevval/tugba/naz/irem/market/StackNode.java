package com.sevval.tugba.naz.irem.market;

public class StackNode {
    public Vendor vendor; // Vendor object
    public StackNode next; // Pointer to the next node

    // Constructor
    public StackNode(Vendor vendor) {
        this.vendor = vendor;
        this.next = null;
    }
}