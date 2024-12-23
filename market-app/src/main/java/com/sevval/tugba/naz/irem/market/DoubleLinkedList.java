package com.sevval.tugba.naz.irem.market;

public class DoubleLinkedList {
    private DoubleLinkedListNode head; // Listenin başı
    private DoubleLinkedListNode tail; // Listenin sonu

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertVendor(Vendor vendor) {
        DoubleLinkedListNode newNode = new DoubleLinkedListNode(vendor);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
    }

    public void insertSorted(Vendor vendor) {
        DoubleLinkedListNode newNode = new DoubleLinkedListNode(vendor);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            DoubleLinkedListNode current = head;
            DoubleLinkedListNode previous = null;
            while (current != null && current.getVendor().getId() < vendor.getId()) {
                previous = current;
                current = current.getNext();
            }
            if (previous == null) {
                newNode.setNext(head);
                head.setPrevious(newNode);
                head = newNode;
            } else {
                newNode.setNext(current);
                newNode.setPrevious(previous);
                previous.setNext(newNode);
                if (current == null) {
                    tail = newNode;
                }
            }
        }
    }

    public void displayForward() {
        DoubleLinkedListNode current = head;
        System.out.println("--- List of Vendors (Forward) ---");
        while (current != null) {
            System.out.println("ID: " + current.getVendor().getId() + ", Name: " + current.getVendor().getName());
            current = current.getNext();
        }
    }

    public void displayBackward() {
        DoubleLinkedListNode current = tail;
        System.out.println("--- List of Vendors (Backward) ---");
        while (current != null) {
            System.out.println("ID: " + current.getVendor().getId() + ", Name: " + current.getVendor().getName());
            current = current.getPrevious();
        }
    }

    public void clear() {
        head = null;
        tail = null;
    }

    public DoubleLinkedListNode getHead() {
        return head;
    }

    public DoubleLinkedListNode getTail() {
        return tail;
    }
}
