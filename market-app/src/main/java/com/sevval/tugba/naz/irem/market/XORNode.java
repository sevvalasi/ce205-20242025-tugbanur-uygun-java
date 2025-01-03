/**
 * @package com.sevval.tugba.naz.irem.market
 * @brief The package contains classes and data structures related to the Market application.
 * @details This package includes implementations for various data structures, including the XOR-linked list node.
 */
package com.sevval.tugba.naz.irem.market;


/**
 * @class XORNode
 * @brief Represents a node in an XOR-linked list.
 * @details This class is a part of the XOR-linked list implementation, where each node stores a reference
 *          that is the XOR of the memory addresses of the previous and next nodes. This approach saves memory
 *          compared to a traditional doubly linked list.
 */
public class XORNode {
	MarketHours data;   ///< The data stored in this node, representing market hours information.
    XORNode both;       ///< The XOR of the previous and next nodes.

    /**
     * @brief Constructor for the `XORNode` class.
     * @details Initializes the node with the provided data and sets the `both` reference to `null`.
     * @param data The `MarketHours` object to be stored in this node.
     */
    public XORNode(MarketHours data) {
        this.data = data;
        this.both = null;
    }

}
