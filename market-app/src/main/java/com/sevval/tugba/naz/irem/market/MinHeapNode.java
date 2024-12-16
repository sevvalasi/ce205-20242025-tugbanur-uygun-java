package com.sevval.tugba.naz.irem.market;

class MinHeapNode {
    char data;
    int freq;
    MinHeapNode left, right;

    MinHeapNode(char data, int freq) {
        this.data = data;
        this.freq = freq;
        this.left = null;
        this.right = null;
    }
}
