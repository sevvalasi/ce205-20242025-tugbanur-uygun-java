/**
 * @package com.sevval.tugba.naz.irem.market
 * @brief The package contains classes and data structures related to the Market application.
 * @details This package includes an implementation of an XOR-linked list for efficient memory usage.
 */
package com.sevval.tugba.naz.irem.market;


/**
 * @class XorLinkedList
 * @brief Represents an XOR-linked list.
 * @details The XOR-linked list is a memory-efficient doubly linked list where each node stores the XOR of the 
 *          memory addresses of its previous and next nodes. This reduces memory usage compared to a traditional
 *          doubly linked list.
 */
public class XorLinkedList {
	
	private XORNode head;    ///< The head node of the XOR-linked list.

	
	/**
     * @brief Constructor for the `XorLinkedList` class.
     * @details Initializes an empty XOR-linked list with the `head` set to `null`.
     */
    public XorLinkedList() {
        this.head = null;
    }

    // Additional methods for adding, removing, and traversing nodes would be implemented here.
}
