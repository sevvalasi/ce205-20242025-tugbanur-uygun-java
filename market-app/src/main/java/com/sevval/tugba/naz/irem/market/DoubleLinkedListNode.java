package com.sevval.tugba.naz.irem.market;

public class DoubleLinkedListNode {
    Vendor vendor; // Vendor objesi
    DoubleLinkedListNode next; // Sonraki düğüm
    DoubleLinkedListNode previous; // Önceki düğüm

    // Constructor
    public DoubleLinkedListNode(Vendor vendor) {
        this.vendor = vendor;
        this.next = null;
        this.previous = null;
    }

    // Getters ve Setters
    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public DoubleLinkedListNode getNext() {
        return next;
    }

    public void setNext(DoubleLinkedListNode next) {
        this.next = next;
    }

    public DoubleLinkedListNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleLinkedListNode previous) {
        this.previous = previous;
    }

	public Vendor getData() {
		// TODO Auto-generated method stub
		return null;
	}
}