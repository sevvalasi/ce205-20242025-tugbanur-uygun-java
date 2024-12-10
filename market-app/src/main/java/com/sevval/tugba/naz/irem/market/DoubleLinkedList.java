package com.sevval.tugba.naz.irem.market;
import static java.lang.System.out;

public class DoubleLinkedList {
    static DoubleLinkedListNode head; // Listenin başı
    private DoubleLinkedListNode tail; // Listenin sonu

    // Yeni bir düğüm eklemek için metod
    public void insert(Vendor vendor) {
        DoubleLinkedListNode newNode = new DoubleLinkedListNode(vendor);
        if (head == null) { // Liste boşsa
            head = newNode;
            tail = newNode;
        } else { // Listenin sonuna ekle
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
    }

    // Vendor'ları ID'ye göre sıralı eklemek için metod
    public void insertSorted(Vendor vendor) {
        DoubleLinkedListNode newNode = new DoubleLinkedListNode(vendor);

        if (head == null) { // Liste boşsa
            head = newNode;
            tail = newNode;
        } else {
            DoubleLinkedListNode current = head;
            DoubleLinkedListNode previous = null;

            // Vendor ID'ye göre doğru konumu bul
            while (current != null && current.getVendor().getId() < vendor.getId()) {
                previous = current;
                current = current.getNext();
            }

            if (previous == null) { // Baştan ekleme
                newNode.setNext(head);
                head.setPrevious(newNode);
                head = newNode;
            } else { // Ortaya veya sona ekleme
                newNode.setNext(current);
                newNode.setPrevious(previous);
                previous.setNext(newNode);
                if (current != null) {
                    current.setPrevious(newNode);
                } else {
                    tail = newNode; // Eğer sona eklenmişse tail güncellenir
                }
            }
        }
    }

    // Listeyi ileriye doğru yazdırma
    public void displayForward() {
        DoubleLinkedListNode current = head;
        out.println("--- List of Vendors (Forward) ---");
        while (current != null) {
            out.println("ID: " + current.getVendor().getId() + ", Name: " + current.getVendor().getName());
            current = current.getNext();
        }
    }

    // Listeyi geriye doğru yazdırma
    public void displayBackward() {
        DoubleLinkedListNode current = tail;
        out.println("--- List of Vendors (Backward) ---");
        while (current != null) {
            out.println("ID: " + current.getVendor().getId() + ", Name: " + current.getVendor().getName());
            current = current.getPrevious();
        }
    }

    // Listeyi temizleme
    public void clear() {
        head = null;
        tail = null;
    }

    // Getters
    public DoubleLinkedListNode getHead() {
        return head;
    }

    public DoubleLinkedListNode getTail() {
        return tail;
    }
}

