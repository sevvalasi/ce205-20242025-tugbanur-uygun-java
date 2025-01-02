package com.sevval.tugba.naz.irem.market;

public class HuffmanCoding {

    private void swapMinHeapNode(MinHeapNode[] a, int i, int j) {
        MinHeapNode t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

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

    private MinHeapNode extractMin(MinHeap minHeap) {
        MinHeapNode temp = minHeap.array[0];
        minHeap.array[0] = minHeap.array[minHeap.size - 1];
        minHeap.size--;
        minHeapify(minHeap, 0);
        return temp;
    }

    private void insertMinHeap(MinHeap minHeap, MinHeapNode minHeapNode) {
        int i = minHeap.size;
        minHeap.size++;

        while (i > 0 && minHeapNode.freq < minHeap.array[(i - 1) / 2].freq) {
            minHeap.array[i] = minHeap.array[(i - 1) / 2];
            i = (i - 1) / 2;
        }

        minHeap.array[i] = minHeapNode;
    }

    private void buildMinHeap(MinHeap minHeap) {
        int n = minHeap.size - 1;
        for (int i = (n - 1) / 2; i >= 0; --i) {
            minHeapify(minHeap, i);
        }
    }

    public MinHeap createAndBuildMinHeap(char[] data, int[] freq, int size) {
        MinHeap minHeap = new MinHeap(size);

        for (int i = 0; i < size; ++i) {
            minHeap.array[i] = new MinHeapNode(data[i], freq[i]);
        }

        minHeap.size = size;
        buildMinHeap(minHeap);

        return minHeap;
    }

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

    public void HuffmanCodes(char[] data, int[] freq, int size) {
        MinHeapNode root = buildHuffmanTree(data, freq, size);
        int[] arr = new int[100];  // Assuming maximum height of Huffman Tree here
        int top = 0;
        printCodes(root, arr, top);
    }
}
