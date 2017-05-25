package com.xiaomingyk.alg;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

/**
 * Created by My on 5/23/2017.
 */

public class BinTreeNode{

    private int value;

    private BinTreeNode left;

    private BinTreeNode right;

    public BinTreeNode(int value){

        this.value = value;
    }

    public BinTreeNode(int value,BinTreeNode left,BinTreeNode right){

        this.value = value;
        this.left = left;
        this.right = right;
    }

    // 1 2 3 # # 4 # 5 6
    //        1
    //    2       3
    // #     #  4    #
    //        5    6
    public static BinTreeNode createTree(ArrayList<String> tree){

        if(tree==null || tree.isEmpty())
            return null;

        int skip = 0;

        BinTreeNode root = new BinTreeNode(Integer.parseInt(tree.get(0)));

        ArrayDeque<BinTreeNode> queue = new ArrayDeque<BinTreeNode>();

        queue.addLast(root);

        for(int i = 1; i < tree.size() && (! queue.isEmpty());i++){

            BinTreeNode parent = queue.pollFirst();

            if(tree.get(i).equals("#")){

                parent.left = null;

            }else {

                BinTreeNode left = new BinTreeNode(Integer.parseInt(tree.get(i)));

                parent.left = left;

                queue.addLast(left);

            }

            i++;

            if(i >= tree.size())break;

            if(tree.get(i).equals("#")){

                parent.right = null;

            }else {

                BinTreeNode right = new BinTreeNode(Integer.parseInt(tree.get(i)));

                parent.right = right;

                queue.addLast(right);
            }
        }

        return root;
    }
    public void setLeft(BinTreeNode left) {

        this.left = left;
    }

    public int getValue() {

        return value;
    }

    public void setRight(BinTreeNode right) {

        this.right = right;
    }

    public void setValue(int value) {

        this.value = value;
    }

    public BinTreeNode getLeft() {

        return left;
    }

    public BinTreeNode getRight() {

        return right;
    }
}

final class MyEntry<K, V> implements Map.Entry<K, V> {
    private final K key;
    private V value;

    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public V setValue(V value) {
        V old = this.value;
        this.value = value;
        return old;
    }
}