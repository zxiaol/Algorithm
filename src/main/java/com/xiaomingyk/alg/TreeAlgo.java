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
    public static ArrayList<ArrayList<Integer>> traverseBinTreeByLevelOrder(ArrayList<String> tree){

        BinTreeNode binTree = BinTreeNode.createTree(tree);

        ArrayList<ArrayList<Integer>> visitRlts = new ArrayList<ArrayList<Integer>>();

        ArrayDeque<MyEntry<BinTreeNode,Integer>> visitQ = new ArrayDeque<MyEntry<BinTreeNode, Integer>>();

        if(binTree != null){

            visitQ.addLast(new MyEntry<BinTreeNode, Integer>(binTree,0));
        }

        while (! visitQ.isEmpty()){

            MyEntry<BinTreeNode,Integer> cnt = visitQ.pollFirst();

            if(visitRlts.size() == cnt.getValue()){

                visitRlts.add(new ArrayList<Integer>());
            }

            visitRlts.get(cnt.getValue()).add(cnt.getKey().getValue());

            if(cnt.getKey().getLeft()!=null){

                visitQ.addLast(new MyEntry<BinTreeNode, Integer>(cnt.getKey().getLeft(),cnt.getValue()+1));
            }

            if(cnt.getKey().getRight()!=null){

                visitQ.addLast(new MyEntry<BinTreeNode, Integer>(cnt.getKey().getRight(),cnt.getValue()+1));
            }

        }

        for(int i = 0; i < visitRlts.size();i++){

            for (int j = 0; j < visitRlts.get(i).size(); j++){

                System.out.print(visitRlts.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }

        return visitRlts;
    }

    public boolean isSymmetricTree(BinTreeNode root){

        if(root == null) return true;

        if(root.getLeft() == null && root.getRight() == null)
            return true;
        else if(root.getLeft() == null || root.getRight() == null)
            return false;

        if(root.getLeft().getValue() != root.getRight().getValue()) {
            return false;
        }

        Stack<BinTreeNode> leftStack = new Stack<BinTreeNode>();
        leftStack.push(root.getLeft());

        Stack<BinTreeNode> rightStack = new Stack<BinTreeNode>();
        rightStack.push(root.getRight());

        while ((!leftStack.isEmpty()) && (!rightStack.isEmpty())){

            BinTreeNode left = leftStack.peek();
            BinTreeNode right = rightStack.peek();

            if(left.getLeft()!=null && right.getRight()!=null){

                if(left.getLeft().getValue() != right.getRight().getValue())
                    return false;

                leftStack.push(left.getLeft());

                rightStack.push(right.getRight());

            }else if(left.getLeft() == null && right.getRight() == null){

                while ((!leftStack.isEmpty()) && (!rightStack.isEmpty())){

                    BinTreeNode tLeft = leftStack.pop();
                    BinTreeNode tRight = rightStack.pop();

                    if(tLeft.getRight()!=null && tRight.getLeft() != null){

                        if(tLeft.getRight().getValue() != tRight.getLeft().getValue()){

                            return false;
                        }

                        leftStack.push(tLeft.getRight());

                        rightStack.push(tRight.getLeft());

                        break;

                    }else if(tLeft.getRight()==null && tRight.getLeft() == null){

                        continue;

                    }else{

                        return false;
                    }

                }
            }else{

                return false;
            }
        }

        if(leftStack.isEmpty() && rightStack.isEmpty())
            return true;

        return false;
    }

    public boolean isSameTree(BinTreeNode tree1, BinTreeNode tree2){

        if(tree1 == null && tree2 == null) return true;

        if(tree1 != null && tree2 != null) return tree1.equals(tree2);

        return false;
    }

    public boolean isBalancedTree(BinTreeNode tree){

        if(tree == null) return true;

        int height = getBlancedHeight(tree);

        if(height > 0) return true;

        return false;
    }

    private int getBlancedHeight(BinTreeNode tree) {

        if(tree == null)
            return 0;

        int leftHeight = getBlancedHeight(tree.getLeft());

        if(leftHeight == -1) return -1;

        int rightHeight = getBlancedHeight(tree.getRight());

        if(rightHeight == -1) return -1;

        if(Math.abs(leftHeight-rightHeight) > 1)
            return -1;

        return Math.max(leftHeight,rightHeight)+1;
    }

    public ArrayList<ArrayList<BinTreeNode>> getPathSumEqualTo(BinTreeNode tree, int target){

        if(tree == null) return null;

        Stack<MyEntry<BinTreeNode,Integer>> stack = new Stack<MyEntry<BinTreeNode, Integer>>();

        ArrayList<ArrayList<BinTreeNode>> rltPath = new ArrayList<ArrayList<BinTreeNode>>();

        ArrayList<BinTreeNode> cntPath = new ArrayList<BinTreeNode>();

        stack.push(new MyEntry<BinTreeNode, Integer>(tree,tree.getValue()));

        cntPath.add(tree);

        while(!stack.isEmpty()){

            MyEntry<BinTreeNode,Integer> top = stack.peek();

            if(top.getKey().getLeft() == null && top.getKey().getRight()==null){

                if(top.getValue() == target){

                    rltPath.add(cntPath);

                    cntPath = (ArrayList<BinTreeNode>) cntPath.clone();
                }

                while (!stack.isEmpty()){

                    BinTreeNode tTop = stack.pop().getKey();

                    cntPath.remove(tTop);

                    if(tTop.getRight())
                }
            }else if(top.getKey().getLeft()!=null){

                int sum = top.getKey().getValue() + top.getKey().getLeft().getValue();
                stack.add(new MyEntry<BinTreeNode, Integer>(top.getKey().getLeft(),sum));
                cntPath.add(top.getKey().getLeft());

            }else if(top.getKey().getRight()!=null){

                int sum = top.getKey().getValue() + top.getKey().getRight().getValue();
                stack.pop();
                stack.add(new MyEntry<BinTreeNode, Integer>(top.getKey().getRight(),sum));
                cntPath.add(top.getKey().getRight());

            }


        }



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
