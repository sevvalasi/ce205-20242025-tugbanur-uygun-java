/**
 * @package com.sevval.tugba.naz.irem.market
 * @brief The package contains classes and data structures for the Market application.
 * @details This package includes the implementation of a Min-Heap node for use in algorithms like Huffman encoding.
 */
package com.sevval.tugba.naz.irem.market;


/**
 * @class MinHeapNode
 * @brief Represents a node in a Min-Heap structure.
 * @details The `MinHeapNode` class is used in Min-Heap implementations, commonly for algorithms such as Huffman encoding.
 *          Each node stores a character, its frequency, and pointers to its left and right child nodes.
 */
class MinHeapNode {
    char data;     ///< The character stored in the node.
    int freq;      ///< The frequency of the character.
    MinHeapNode left, right;      ///< Pointers to the left and right child nodes.

    
    /**
     * @brief Constructor for the `MinHeapNode` class.
     * @details Initializes a Min-Heap node with the given character and frequency, with child nodes set to `null`.
     * @param data The character to store in the node.
     * @param freq The frequency of the character.
     */
    MinHeapNode(char data, int freq) {
        this.data = data;
        this.freq = freq;
        this.left = null;
        this.right = null;
    }
}
