package com.company.my;

import com.company.my.solver.NodeShortestWaySolver;
import com.company.my.solver.ShortestWay;

public class Main {

    public static void main(String[] args) {
        Node h = new Node("H");
        Node i = new Node("I");
        Node d = new Node("D", h, i);

        Node j = new Node("J");
        Node e = new Node("E", j, null);

        Node b = new Node("B", d, e);

        Node f = new Node("F");
        Node g = new Node("G");
        Node c = new Node("C", f, g);

//done, root node
        Node a = new Node("A", b, c);


        ShortestWay way = NodeShortestWaySolver.findShortestWay(a);
        System.out.println("way...\n length: " + way.wayLength + "\n name: " + way.wayName);
    }
}
