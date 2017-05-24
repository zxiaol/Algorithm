package com.xiaomingyk.alg;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class TreeAlgo {

    public static int getDepthOfBinaryTree(BinTreeNode node){

        if(node == null)
            return 0;

        int lDepth = getDepthOfBinaryTree(node.getLeft());

        int rDepth = getDepthOfBinaryTree(node.getRight());

        return Math.max(lDepth,rDepth)+1;
    }

    public static int getDepthOfBinaryTreeNunRecurse(BinTreeNode node){

        if(node == null)
            return 0;

        int depth = 1;

        Stack<MyEntry<BinTreeNode,Integer>> stack = new Stack<MyEntry<BinTreeNode, Integer>>();

        stack.push(new MyEntry<BinTreeNode,Integer>(node,depth));

        while (!stack.empty()){

            MyEntry<BinTreeNode,Integer> cnt = stack.pop();

            if(cnt.getKey().getRight() != null){

                stack.push(new MyEntry<BinTreeNode, Integer>(cnt.getKey().getRight(),cnt.getValue()+1));
            }

            if(cnt.getKey().getLeft() != null){

                stack.push(new MyEntry<BinTreeNode, Integer>(cnt.getKey().getLeft(),cnt.getValue()+1));
            }

            if(cnt.getValue() > depth){
                depth = cnt.getValue();
            }
        }

        return depth;
    }

    public static BinTreeNode constructTreeFromInPostOrder(int[] inOrder, int[] postOrder){

        //Inorder: 4251637; postOrder: 4526731

        int startInorder = 0;
        int endInorder = inOrder.length - 1;

        int startPostOrder = 0;
        int endPostOrder = postOrder.length - 1;

        return myConstructTreeFromInPostOrder(inOrder,startInorder,endInorder,postOrder,startPostOrder,endPostOrder);
    }

    private static BinTreeNode myConstructTreeFromInPostOrder(int[] inOrder,
                                                              int startInorder, int endInorder,
                                                              int[] postOrder, int startPostOrder,
                                                              int endPostOrder) {

        BinTreeNode node = new BinTreeNode(postOrder[endPostOrder]);

        int pivot = Arrays.asList(inOrder).indexOf(postOrder[endPostOrder]);

        BinTreeNode leftNode = myConstructTreeFromInPostOrder(inOrder,startInorder,pivot-1,
                postOrder,startPostOrder,startPostOrder+pivot-startInorder-1);

        BinTreeNode rightNode = myConstructTreeFromInPostOrder(inOrder,pivot+1,endInorder,
                postOrder,endPostOrder-endInorder+pivot,endPostOrder-1);

        node.setLeft(leftNode);

        node.setRight(rightNode);

        return node;
    }

    // input {3,9,20,#,#,15,7} return
    // [
    //   [3],
    //   [9,20]
    //   [15,7]
    // ]
    public static ArrayList<ArrayList<String>> traverseBinTreeByLevelOrder(ArrayList<String> tree){

        ArrayList<ArrayList<Integer>> visitRlts = new ArrayList<ArrayList<Integer>>();


        ArrayDeque<MyEntry<Integer,Integer>> visitQ = new ArrayDeque<MyEntry<Integer, Integer>>();

        return null;
    }

    public boolean isSymmetricTree(BinTreeNode root){

        return false;
    }

    public boolean isSameTree(BinTreeNode tree1, BinTreeNode tree2){

        return false;
    }

    public boolean isBalancedTree(BinTreeNode tree){

        return false;
    }

    public int[] getPathSumEqualTo(BinTreeNode tree, int target){

        return null;
    }

    public int[] preorderTraverse(BinTreeNode tree){

        return null;
    }

    public int[] inorderTraverse(BinTreeNode tree){

        return null;
    }

    public int[] postorderTraverse(BinTreeNode tree){

        return null;
    }
}
