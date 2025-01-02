package com.sevval.tugba.naz.irem.market;
public class Stack {
    public StackNode top;

    public boolean isStackEmpty() {
        return top == null;
    }

    public void push(Vendor vendor) {
        StackNode newNode = new StackNode(vendor);
        newNode.next = top;
        top = newNode;
    }

    public Vendor pop() {
        if (isStackEmpty()) {
            return new Vendor(0, ""); // Return an empty vendor object
        }
        Vendor vendor = top.vendor;
        top = top.next;
        return vendor;
    }

    public void freeStack() {
        while (!isStackEmpty()) {
            pop();
        }
    }
}

