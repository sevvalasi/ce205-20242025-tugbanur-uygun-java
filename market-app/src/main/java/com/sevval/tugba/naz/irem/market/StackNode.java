/**
 * @package com.sevval.tugba.naz.irem.market
 * @brief The package contains classes and data structures for the Market application.
 * @details This package includes the implementation of a stack node for managing vendor objects in a stack-based data structure.
 */
package com.sevval.tugba.naz.irem.market;


/**
 * @class StackNode
 * @brief Represents a node in a stack.
 * @details This class is used to create nodes for a stack data structure, where each node contains a `Vendor` object and a pointer to the next node.
 */
public class StackNode {
    public Vendor vendor; ///< The vendor object stored in this node.
    public StackNode next;  ///< Pointer to the next node in the stack.

    /**
     * @brief Constructor for the `StackNode` class.
     * @details Initializes a stack node with the provided `Vendor` object. 
     *          The `next` pointer is initialized to `null` by default.
     * @param vendor The `Vendor` object to be stored in this node.
     */
    public StackNode(Vendor vendor) {
        this.vendor = vendor;
        this.next = null;
    }
}