package com.maureen.dp.composite;


public class Main {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode chapter1 = new BranchNode("chapter1");
        BranchNode chapter2 = new BranchNode("chapter2");

        Node c11 = new LeafNode("c11");
        Node c12 = new LeafNode("c12");

        BranchNode b21 = new BranchNode("section21");
        Node c211 = new LeafNode("c211");
        Node c212 = new LeafNode("c212");

        root.add(chapter1);
        root.add(chapter2);

        chapter1.add(c11);
        chapter1.add(c12);

        b21.add(c211);
        b21.add(c212);

        tree(root, 0); //可以显示树状结构
        //tree(root)

    }

    static void tree(Node b) {
        b.print();
        if (b instanceof BranchNode) {
            for (Node n : ((BranchNode) b).nodes)
                tree(n);
        }
    }

    static void tree(Node b, int depth) {
        for (int i = 0; i < depth; i++)
            System.out.print("--");
        b.print();
        if (b instanceof BranchNode) {
            for (Node n : ((BranchNode) b).nodes) {
                tree(n, depth + 1);
            }
        }
    }
}
