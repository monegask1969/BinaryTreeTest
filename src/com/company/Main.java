package com.company;

import com.company.Tree.BinaryTree;
import com.company.Tree.Node;

public class Main {
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node('A');
        tree.root.left = new Node('B');
        tree.root.right = new Node('C');

        tree.root.right.right = new Node('G');
        tree.root.right.left = new Node('F');

        tree.root.left.left = new Node('D');
        tree.root.left.right = new Node('E');

        tree.root.left.right.left = new Node('J');

        tree.root.left.left.left = new Node('H');
        tree.root.left.left.right = new Node('I');


        char k = 'A';
        System.out.println(tree.getMin(tree.closestDown(tree.root.left), tree.closestDown(tree.root.right)));
        System.out.println("Distace of the closest key from " + k + " is "
                + tree.findClosest(tree.root, k));
    }
}
