/**
 * @package com.sevval.tugba.naz.irem.market
 * @brief The package contains classes and data structures for the Market application.
 * @details This package includes the implementation of a doubly linked list node to store `Vendor` objects and enable bidirectional traversal.
 */
package com.sevval.tugba.naz.irem.market;


/**
 * @class DoubleLinkedListNode
 * @brief Represents a node in a doubly linked list.
 * @details The `DoubleLinkedListNode` class stores a `Vendor` object and provides pointers to the next and previous nodes, 
 *          enabling bidirectional traversal within the linked list.
 */
public class DoubleLinkedListNode {
    Vendor vendor; 
    DoubleLinkedListNode next; 
    DoubleLinkedListNode previous; 

    /**
     * @brief Constructor for the `DoubleLinkedListNode` class.
     * @details Initializes a node with the specified `Vendor` object and sets the `next` and `previous` pointers to `null`.
     * @param vendor The `Vendor` object to store in the node.
     */
    public DoubleLinkedListNode(Vendor vendor) {
        this.vendor = vendor;
        this.next = null;
        this.previous = null;
    }

    /**
     * @brief Retrieves the `Vendor` object stored in the node.
     * @return The `Vendor` object.
     */
    public Vendor getVendor() {
        return vendor;
    }

    
    /**
     * @brief Sets the `Vendor` object for the node.
     * @param vendor The `Vendor` object to store.
     */
    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    /**
     * @brief Retrieves the next node in the linked list.
     * @return A pointer to the next `DoubleLinkedListNode`.
     */
    public DoubleLinkedListNode getNext() {
        return next;
    }

    /**
     * @brief Sets the next node in the linked list.
     * @param next A pointer to the next `DoubleLinkedListNode`.
     */
    public void setNext(DoubleLinkedListNode next) {
        this.next = next;
    }

    /**
     * @brief Retrieves the previous node in the linked list.
     * @return A pointer to the previous `DoubleLinkedListNode`.
     */
    public DoubleLinkedListNode getPrevious() {
        return previous;
    }

    /**
     * @brief Sets the previous node in the linked list.
     * @param previous A pointer to the previous `DoubleLinkedListNode`.
     */
    public void setPrevious(DoubleLinkedListNode previous) {
        this.previous = previous;
    }

    /**
     * @brief Retrieves the data (vendor) stored in the node.
     * @return The `Vendor` object.
     * @note Placeholder method. Implementation needed if further processing is required.
     */
	public Vendor getData() {
		// TODO Auto-generated method stub
		return null;
	}
}