package com.company.my.solver;

import com.company.my.Node;

public class NodeShortestWaySolver {

    public static ShortestWay findShortestWay(Node nodeToFindFrom) {
        ShortestWay initialWay = new ShortestWay(1, nodeToFindFrom.getName());
        return findShortestSubWay(initialWay, nodeToFindFrom);
    }

    private static ShortestWay findShortestSubWay(ShortestWay currentWay, Node subNodeToFindFrom) {
        if(subNodeToFindFrom.getLeft() == null && subNodeToFindFrom.getRight() == null) {
            return currentWay;
        }else if(subNodeToFindFrom.getLeft() == null) {
            //у текущего элемента child только справа, безоговорочно идем в него
           return findShortestSubWay(new ShortestWay(currentWay.wayLength + 1,
                   currentWay.wayName + subNodeToFindFrom.getRight().getName()),
                   subNodeToFindFrom.getRight());
        } else if (subNodeToFindFrom.getRight() == null) {
            //у текущего элемента child только слева, безоговорочно идем в него
            return findShortestSubWay(new ShortestWay(currentWay.wayLength + 1,
                    currentWay.wayName + subNodeToFindFrom.getLeft().getName()),
                    subNodeToFindFrom.getLeft());
        } else {
            //Hardest way, if you know what i mean)
            int newWayLength = currentWay.wayLength +1;
            String leftWayName = currentWay.wayName + subNodeToFindFrom.getLeft().getName();
            String rightWayName = currentWay.wayName + subNodeToFindFrom.getRight().getName();
            ShortestWay leftWay = findShortestSubWay(new ShortestWay(newWayLength,leftWayName), subNodeToFindFrom.getLeft());

            ShortestWay rightWay = findShortestSubWay(new ShortestWay(newWayLength,rightWayName), subNodeToFindFrom.getRight());

            return leftWay.wayLength > rightWay.wayLength ? rightWay : leftWay;
        }
    }
}
