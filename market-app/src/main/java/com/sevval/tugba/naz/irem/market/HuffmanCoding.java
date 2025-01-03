/**
 * @package com.sevval.tugba.naz.irem.market
 * @brief The package contains classes and algorithms for the Market application.
 * @details This package includes the implementation of Huffman Coding, a compression algorithm.
 */
package com.sevval.tugba.naz.irem.market;


/**
 * @class HuffmanCoding
 * @brief Implements the Huffman Coding algorithm for data compression.
 * @details The `HuffmanCoding` class provides methods for building a Huffman Tree, generating Huffman codes, 
 *          and printing the corresponding codes for characters based on their frequencies.
 */
public class HuffmanCoding {

	
	 /**
     * @brief Swaps two nodes in the Min-Heap array.
     * @param a The array representing the Min-Heap.
     * @param i Index of the first node.
     * @param j Index of the second node.
     */
    private void swapMinHeapNode(MinHeapNode[] a, int i, int j) {
        MinHeapNode t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    
    /**
     * @brief Maintains the Min-Heap property.
     * @details Ensures the node at the given index and its subtree satisfy the Min-Heap property.
     * @param minHeap The Min-Heap object.
     * @param idx The index of the node to heapify.
     */
    private void minHeapify(MinHeap minHeap, int idx) {
        int smallest = idx;
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if (left < minHeap.size && minHeap.array[left].freq < minHeap.array[smallest].freq) {
            smallest = left;
        }

        if (right < minHeap.size && minHeap.array[right].freq < minHeap.array[smallest].freq) {
            smallest = right;
        }

        if (smallest != idx) {
            swapMinHeapNode(minHeap.array, smallest, idx);
            minHeapify(minHeap, smallest);
        }
    }

    
    /**
     * @brief Extracts the minimum value node from the Min-Heap.
     * @param minHeap The Min-Heap object.
     * @return The node with the minimum frequency.
     */
    private MinHeapNode extractMin(MinHeap minHeap) {
        MinHeapNode temp = minHeap.array[0];
        minHeap.array[0] = minHeap.array[minHeap.size - 1];
        minHeap.size--;
        minHeapify(minHeap, 0);
        return temp;
    }

    
    /**
     * @brief Inserts a new node into the Min-Heap.
     * @param minHeap The Min-Heap object.
     * @param minHeapNode The node to be inserted.
     */
    private void insertMinHeap(MinHeap minHeap, MinHeapNode minHeapNode) {
        int i = minHeap.size;
        minHeap.size++;

        while (i > 0 && minHeapNode.freq < minHeap.array[(i - 1) / 2].freq) {
            minHeap.array[i] = minHeap.array[(i - 1) / 2];
            i = (i - 1) / 2;
        }

        minHeap.array[i] = minHeapNode;
    }

    
    /**
     * @brief Builds a Min-Heap from the given array.
     * @param minHeap The Min-Heap object.
     */
    private void buildMinHeap(MinHeap minHeap) {
        int n = minHeap.size - 1;
        for (int i = (n - 1) / 2; i >= 0; --i) {
            minHeapify(minHeap, i);
        }
    }

    
    /**
     * @brief Creates and builds a Min-Heap from the given data and frequencies.
     * @param data An array of characters.
     * @param freq An array of corresponding frequencies.
     * @param size The size of the data array.
     * @return A Min-Heap containing the data and frequencies.
     */
    public MinHeap createAndBuildMinHeap(char[] data, int[] freq, int size) {
        MinHeap minHeap = new MinHeap(size);

        for (int i = 0; i < size; ++i) {
            minHeap.array[i] = new MinHeapNode(data[i], freq[i]);
        }

        minHeap.size = size;
        buildMinHeap(minHeap);

        return minHeap;
    }

    
    /**
     * @brief Builds a Huffman Tree from the given data and frequencies.
     * @param data An array of characters.
     * @param freq An array of corresponding frequencies.
     * @param size The size of the data array.
     * @return The root node of the Huffman Tree.
     */
    public MinHeapNode buildHuffmanTree(char[] data, int[] freq, int size) {
        MinHeapNode left, right, top;

        MinHeap minHeap = createAndBuildMinHeap(data, freq, size);

        while (minHeap.size != 1) {
            left = extractMin(minHeap);
            right = extractMin(minHeap);

            top = new MinHeapNode('$', left.freq + right.freq);
            top.left = left;
            top.right = right;

            insertMinHeap(minHeap, top);
        }

        return extractMin(minHeap);
    }

    
    /**
     * @brief Prints the Huffman codes for the given Huffman Tree.
     * @param root The root node of the Huffman Tree.
     * @param arr An array to store the current code.
     * @param top The current position in the code array.
     */
    private void printCodes(MinHeapNode root, int[] arr, int top) {
        if (root.left != null) {
            arr[top] = 0;
            printCodes(root.left, arr, top + 1);
        }

        if (root.right != null) {
            arr[top] = 1;
            printCodes(root.right, arr, top + 1);
        }

        if (root.left == null && root.right == null) {
            System.out.print(root.data + ": ");
            for (int i = 0; i < top; ++i) {
                System.out.print(arr[i]);
            }
            System.out.println();
        }
    }

    
    /**
     * @brief Generates and prints the Huffman codes for the given data and frequencies.
     * @param data An array of characters.
     * @param freq An array of corresponding frequencies.
     * @param size The size of the data array.
     */
    public void HuffmanCodes(char[] data, int[] freq, int size) {
        MinHeapNode root = buildHuffmanTree(data, freq, size);
        int[] arr = new int[100];  // Assuming maximum height of Huffman Tree here
        int top = 0;
        printCodes(root, arr, top);
    }
}
