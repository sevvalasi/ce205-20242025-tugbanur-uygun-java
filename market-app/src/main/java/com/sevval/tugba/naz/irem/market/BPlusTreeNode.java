/**
 * @package com.sevval.tugba.naz.irem.market
 * @brief The package contains classes related to the Market application.
 * @details This package includes data structures and algorithms used for managing and storing application data.
 */
package com.sevval.tugba.naz.irem.market;

/**
 * @class BPlusTreeNode
 * @brief Represents a node in a B+ Tree.
 * @details This class implements the structure and behavior of a node in a B+ Tree, including its keys, children, 
 *          and relationships with other nodes. Nodes can be either internal nodes or leaf nodes.
 */
public class BPlusTreeNode {

	private int[] keys; ///< Array to store the keys in the node.
    private BPlusTreeNode[] children; ///< Array to store references to child nodes.
    private boolean isLeaf; ///< Flag indicating whether the node is a leaf node.
    private BPlusTreeNode next; ///< Pointer to the next leaf node (used in leaf nodes for sequential access).
    private int keyCount; ///< The number of keys currently stored in the node.
    private static final int MAX_KEYS = 4; ///< The maximum number of keys a node can hold.

    /**
     * @brief Default constructor for BPlusTreeNode.
     * @details Initializes the node with default values. The node is initialized as a leaf node by default.
     */
    public BPlusTreeNode() {
        this.keys = new int[MAX_KEYS];
        this.children = new BPlusTreeNode[MAX_KEYS + 1];
        this.keyCount = 0;
        this.next = null;
        this.isLeaf = true;
    }

    /**
     * @brief Constructor for creating a node with a specified type (leaf or internal).
     * @param isLeaf `true` if the node is a leaf node; otherwise, `false`.
     */
    public BPlusTreeNode(boolean isLeaf) {
        this();
        this.isLeaf = isLeaf;
    }

    /**
     * @brief Creates a new leaf node.
     * @return A new instance of `BPlusTreeNode` initialized as a leaf node.
     */
    public static BPlusTreeNode createNode() {
        return new BPlusTreeNode();
    }

    /**
     * @brief Retrieves the key at a specified index.
     * @param index The index of the key to retrieve.
     * @return The key at the specified index.
     */
    public int getKey(int index) {
        return keys[index];
    }

    /**
     * @brief Retrieves the child node at a specified index.
     * @param index The index of the child node to retrieve.
     * @return A reference to the child node at the specified index.
     */
    public BPlusTreeNode getChild(int index) {
        return children[index];
    }

    /**
     * @brief Checks whether the node is a leaf node.
     * @return `true` if the node is a leaf node; otherwise, `false`.
     */
    public boolean getIsLeaf() {
        return isLeaf;
    }

    /**
     * @brief Retrieves the next leaf node.
     * @return A reference to the next leaf node.
     */
    public BPlusTreeNode getNext() {
        return next;
    }

    /**
     * @brief Retrieves the number of keys in the node.
     * @return The number of keys stored in the node.
     */
    public int getKeyCount() {
        return keyCount;
    }

    /**
     * @brief Sets the key at a specified index.
     * @param index The index at which to set the key.
     * @param key The key value to set.
     */
    public void setKey(int index, int key) {
        keys[index] = key;
    }

    /**
     * @brief Sets the child node at a specified index.
     * @param index The index at which to set the child node.
     * @param child The child node to set.
     */
    public void setChild(int index, BPlusTreeNode child) {
        children[index] = child;
    }

    /**
     * @brief Sets the node type as leaf or internal.
     * @param isLeaf `true` if the node is a leaf node; otherwise, `false`.
     */
    public void setIsLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    /**
     * @brief Sets the pointer to the next leaf node.
     * @param next The reference to the next leaf node.
     */
    public void setNext(BPlusTreeNode next) {
        this.next = next;
    }

    /**
     * @brief Sets the number of keys in the node.
     * @param count The number of keys to set.
     */
    public void setKeyCount(int count) {
        this.keyCount = count;
    }
}