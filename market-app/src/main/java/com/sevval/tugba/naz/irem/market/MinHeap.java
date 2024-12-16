package com.sevval.tugba.naz.irem.market;

class MinHeap {
    MinHeapNode[] array;
    int size;
    int capacity;

    MinHeap(int capacity) {
        this.capacity = capacity;
        size = 0;
        array = new MinHeapNode[capacity];
    }
}
