package com.sevval.tugba.naz.irem.market;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String info;
    private List<Node> neighbors;

    public Node(String info) {
        this.info = info;
        this.neighbors = new ArrayList<>();
    }

    public String getInfo() {
        return info;
    }

    public void addNeighbor(Node neighbor) {
        neighbors.add(neighbor);
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }
}