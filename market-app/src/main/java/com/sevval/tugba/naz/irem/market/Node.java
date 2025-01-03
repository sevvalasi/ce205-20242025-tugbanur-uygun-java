/**
 * @package com.sevval.tugba.naz.irem.market
 * @brief The package contains classes and data structures for the Market application.
 * @details This package includes the implementation of a graph node for representing relationships between entities.
 */
package com.sevval.tugba.naz.irem.market;

import java.util.ArrayList;
import java.util.List;


/**
 * @class Node
 * @brief Represents a node in a graph structure.
 * @details The `Node` class models an individual node in a graph, storing information about itself and its neighboring nodes.
 *          It is used to represent relationships between different entities, such as products and vendors.
 */
public class Node {
    private final String info;            ///< The information or label associated with the node.
    private final List<Node> neighbors;  ///< A list of neighboring nodes.

    
    /**
     * @brief Constructor for the `Node` class.
     * @details Initializes a node with the given information and an empty list of neighbors.
     * @param info A string representing the information or label associated with the node.
     */
    public Node(String info) {
        this.info = info;
        this.neighbors = new ArrayList<>();
    }

    
    /**
     * @brief Retrieves the information associated with the node.
     * @return A string containing the node's information.
     */
    public String getInfo() {
        return info;
    }

    /**
     * @brief Retrieves the list of neighboring nodes.
     * @return A list of neighboring `Node` objects.
     */
    public List<Node> getNeighbors() {
        return neighbors;
    }

    
    /**
     * @brief Adds a neighboring node to this node.
     * @details Establishes a relationship between this node and the provided neighbor by adding it to the list of neighbors.
     * @param neighbor The `Node` object to add as a neighbor.
     */
    public void addNeighbor(Node neighbor) {
        neighbors.add(neighbor);
    }
}
