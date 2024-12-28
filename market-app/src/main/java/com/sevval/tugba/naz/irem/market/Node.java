package com.sevval.tugba.naz.irem.market;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private final String info;
    private final List<Node> neighbors;

    public Node(String info) {
        this.info = info;
        this.neighbors = new ArrayList<>();
    }

    public String getInfo() {
        return info;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Node neighbor) {
        neighbors.add(neighbor);
    }
}
