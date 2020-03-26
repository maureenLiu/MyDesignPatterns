package com.maureen.dp.composite;

import java.util.ArrayList;
import java.util.List;

public class BranchNode extends Node {
    List<Node> nodes = new ArrayList<>();

    String name;

    public BranchNode(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println(name);
    }

    public void add(Node n) {
        nodes.add(n);
    }
}
