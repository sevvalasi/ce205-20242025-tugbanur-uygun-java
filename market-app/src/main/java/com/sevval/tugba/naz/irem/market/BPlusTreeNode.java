package com.sevval.tugba.naz.irem.market;

public class BPlusTreeNode {

    private int[] keys;
    private BPlusTreeNode[] children;
    private boolean isLeaf;
    private BPlusTreeNode next;
    private int keyCount;
    private static final int MAX_KEYS = 4; // Bu değer gerektiği gibi ayarlanabilir

    // Kurucu metod varsayılan değerlerle düğümü başlatır
    public BPlusTreeNode() {
        this.keys = new int[MAX_KEYS];
        this.children = new BPlusTreeNode[MAX_KEYS + 1];
        this.keyCount = 0;
        this.next = null;
        this.isLeaf = true;  // Varsayılan olarak düğüm yaprak düğüm olarak başlatılabilir
    }

    // Yaprak olmayan bir düğüm oluşturmak için bu metodu kullanabiliriz
    public BPlusTreeNode(boolean isLeaf) {
        this();
        this.isLeaf = isLeaf;
    }

    // Bu metot yeni bir yaprak düğüm oluşturur ve döndürür
    public static BPlusTreeNode createNode() {
        return new BPlusTreeNode();
    }

    // Getter ve setter metodları...

    public int getKey(int index) {
        return keys[index];
    }

    public BPlusTreeNode getChild(int index) {
        return children[index];
    }

    public boolean getIsLeaf() {
        return isLeaf;
    }

    public BPlusTreeNode getNext() {
        return next;
    }

    public int getKeyCount() {
        return keyCount;
    }

    public void setKey(int index, int key) {
        keys[index] = key;
    }

    public void setChild(int index, BPlusTreeNode child) {
        children[index] = child;
    }

    public void setIsLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public void setNext(BPlusTreeNode next) {
        this.next = next;
    }

    public void setKeyCount(int count) {
        this.keyCount = count;
    }
}