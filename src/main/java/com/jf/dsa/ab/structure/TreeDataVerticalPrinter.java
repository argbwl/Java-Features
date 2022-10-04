package com.jf.dsa.ab.structure;

import com.jf.dsa.ab.ds.IntNode;
import com.jf.printer.SystemPrinter;

import java.util.TreeMap;
import java.util.Vector;

/**
 * Java-Features
 * argbwl
 * 28/09/22
 **/
public class TreeDataVerticalPrinter {


    private void getVerticalOrders(IntNode root, int horizontalDistance, TreeMap<Integer, Vector<Integer>> vectorTreeMap){
        if (root == null) return;

        Vector<Integer> integerVector = vectorTreeMap.get(horizontalDistance);

        if (integerVector == null) {
            integerVector = new Vector<>();
        }

        integerVector.add(root.key);

        vectorTreeMap.put(horizontalDistance, integerVector);

        //Store Node in left subtree
        getVerticalOrders(root.left, horizontalDistance-1, vectorTreeMap);

        //Store Node in right subtree
        getVerticalOrders(root.right, horizontalDistance+1, vectorTreeMap);

    }


    public void printVerticalOrder(IntNode node){

        TreeMap<Integer, Vector<Integer>> vectorTreeMap = new TreeMap<>();
        int horizontalDistance = 0;
        getVerticalOrders(node,horizontalDistance,vectorTreeMap);
        vectorTreeMap.forEach((k,v)->SystemPrinter.info(v));

    }

    public static void main(String[] args) {
        TreeDataVerticalPrinter verticalPrinter = new TreeDataVerticalPrinter();
        IntNode root = new IntNode(1);
        root.left = new IntNode(2);
        root.right = new IntNode(3);
        root.left.left = new IntNode(4);
        root.left.right = new IntNode(5);
        root.right.left = new IntNode(6);
        root.right.right = new IntNode(7);
        root.right.left.right = new IntNode(8);
        root.right.right.right = new IntNode(9);
        SystemPrinter.info("Vertical Order traversal is");
        verticalPrinter.printVerticalOrder(root);
    }

}
