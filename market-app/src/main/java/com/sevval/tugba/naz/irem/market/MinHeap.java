/**
 * @package com.sevval.tugba.naz.irem.market
 * @brief The package contains classes and data structures for the Market application.
 * @details This package includes the implementation of a Min-Heap data structure, commonly used in algorithms like Huffman encoding.
 */

package com.sevval.tugba.naz.irem.market;


/**
 * @class MinHeap
 * @brief Represents a Min-Heap data structure.
 * @details The `MinHeap` class implements a Min-Heap, which is a complete binary tree where the value of each node is less than or equal to the values of its children. 
 *          This structure is commonly used in algorithms such as Huffman encoding and priority queues.
 */
class MinHeap {
    MinHeapNode[] array;     ///< The array representation of the Min-Heap.
    int size;                ///< The current number of elements in the heap.
    int capacity;            ///< The maximum capacity of the heap.

    
    /**
     * @brief Constructor for the `MinHeap` class.
     * @details Initializes a Min-Heap with a specified capacity. The heap starts empty, with its size set to 0.
     * @param capacity The maximum capacity of the Min-Heap.
     */
    MinHeap(int capacity) {
        this.capacity = capacity;
        size = 0;
        array = new MinHeapNode[capacity];
    }
}
