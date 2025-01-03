/**
 * @package com.sevval.tugba.naz.irem.market
 * @brief The package contains classes and data structures for the Market application.
 * @details This package includes the implementation of a stack for managing `Vendor` objects.
 */
package com.sevval.tugba.naz.irem.market;

/**
 * @class Stack
 * @brief Represents a stack data structure for managing `Vendor` objects.
 * @details The `Stack` class provides standard stack operations such as push, pop, and check if the stack is empty.
 *          It uses the `StackNode` class to store nodes in the stack.
 */
public class Stack {
    public StackNode top;     ///< The top node of the stack.


    /**
     * @brief Checks if the stack is empty.
     * @return `true` if the stack is empty; otherwise, `false`.
     */
    public boolean isStackEmpty() {
        return top == null;
    }

    
    /**
     * @brief Pushes a `Vendor` object onto the stack.
     * @details Creates a new `StackNode` containing the provided `Vendor` object and adds it to the top of the stack.
     * @param vendor The `Vendor` object to push onto the stack.
     */
    public void push(Vendor vendor) {
        StackNode newNode = new StackNode(vendor);
        newNode.next = top;
        top = newNode;
    }

    /**
     * @brief Pops a `Vendor` object from the stack.
     * @details Removes the top node from the stack and returns the `Vendor` object stored in it.
     *          If the stack is empty, returns an empty `Vendor` object with ID 0 and an empty name.
     * @return The `Vendor` object stored in the popped node.
     */
    public Vendor pop() {
        if (isStackEmpty()) {
            return new Vendor(0, ""); // Return an empty vendor object
        }
        Vendor vendor = top.vendor;
        top = top.next;
        return vendor;
    }

    /**
     * @brief Frees all nodes in the stack.
     * @details Pops all nodes from the stack until it is empty.
     */
    public void freeStack() {
        while (!isStackEmpty()) {
            pop();
        }
    }
}

