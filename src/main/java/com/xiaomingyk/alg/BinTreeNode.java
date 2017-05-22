package com.xiaomingyk.alg;

/**
 * Created by My on 5/23/2017.
 */

public class BinTreeNode{

    private int value;

    private BinTreeNode left;

    private BinTreeNode right;

    public void BinTreeNode(int value){

        this.value = value;
    }

    public void BinTreeNode(int value,BinTreeNode left,BinTreeNode right){

        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void setLeft(BinTreeNode left) {

        this.left = left;
    }

    public void setRight(BinTreeNode right) {

        this.right = right;
    }

    public void setValue(int value) {

        this.value = value;
    }
}
