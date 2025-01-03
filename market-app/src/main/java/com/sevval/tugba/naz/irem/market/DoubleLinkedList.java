/**
 * @package com.sevval.tugba.naz.irem.market
 * @brief The package contains classes and data structures for the Market application.
 * @details This package includes the implementation of a doubly linked list for managing and traversing vendor data.
 */
package com.sevval.tugba.naz.irem.market;


/**
 * @class DoubleLinkedList
 * @brief Represents a doubly linked list structure.
 * @details The `DoubleLinkedList` class provides functionality for managing a doubly linked list of vendors. 
 *          It supports insertion, traversal, and clearing of the list.
 */
public class DoubleLinkedList {
    private DoubleLinkedListNode head; 
    private DoubleLinkedListNode tail; 

    
    /**
     * @brief Default constructor for the `DoubleLinkedList` class.
     * @details Initializes an empty doubly linked list with null head and tail pointers.
     */
    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    
    /**
     * @brief Inserts a vendor at the end of the list.
     * @details Adds a new vendor node to the tail of the doubly linked list.
     * @param vendor The `Vendor` object to insert.
     */
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

    /**
     * @brief Inserts a vendor into the list in sorted order.
     * @details Inserts a new vendor node into the list, maintaining ascending order based on vendor ID.
     * @param vendor The `Vendor` object to insert.
     */
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

    
    /**
     * @brief Displays the list of vendors in forward order.
     * @details Traverses the list from the head to the tail, printing each vendor's ID and name.
     */
    public void displayForward() {
        DoubleLinkedListNode current = head;
        System.out.println("--- List of Vendors (Forward) ---");
        while (current != null) {
            System.out.println("ID: " + current.getVendor().getId() + ", Name: " + current.getVendor().getName());
            current = current.getNext();
        }
    }

    
    /**
     * @brief Displays the list of vendors in backward order.
     * @details Traverses the list from the tail to the head, printing each vendor's ID and name.
     */
    public void displayBackward() {
        DoubleLinkedListNode current = tail;
        System.out.println("--- List of Vendors (Backward) ---");
        while (current != null) {
            System.out.println("ID: " + current.getVendor().getId() + ", Name: " + current.getVendor().getName());
            current = current.getPrevious();
        }
    }

    /**
     * @brief Clears the entire list.
     * @details Removes all nodes from the list by setting the head and tail pointers to `null`.
     */
    public void clear() {
        head = null;
        tail = null;
    }

    
    /**
     * @brief Retrieves the head node of the list.
     * @return A pointer to the head `DoubleLinkedListNode`.
     */
    public DoubleLinkedListNode getHead() {
        return head;
    }
    
    /**
     * @brief Retrieves the tail node of the list.
     * @return A pointer to the tail `DoubleLinkedListNode`.
     */
    public DoubleLinkedListNode getTail() {
        return tail;
    }
}
