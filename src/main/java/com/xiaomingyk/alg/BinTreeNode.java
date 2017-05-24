package com.xiaomingyk.alg;

import java.util.Map;

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

    public void setLeft(BinTreeNode left) {

        this.left = left;
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