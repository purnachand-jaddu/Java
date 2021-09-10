package com.mentor.training.amazon;

import com.mentor.training.TreeNode;

public class IsBinaryTreeASearchTree {


    public static void main(String[] args) {

        //Assume we have a root treeNode
        TreeNode rootNode = new TreeNode(5);

        rootNode.setLeftNode(new TreeNode(1));
        rootNode.setRightNode(new TreeNode(100));

        boolean isBST = checkIFTreeISBST(Long.MIN_VALUE, Long.MAX_VALUE, rootNode);
        System.out.println(isBST);
    }

    private static boolean checkIFTreeISBST(long minValue, long maxValue, TreeNode rootNode) {

        if (rootNode == null) {
            return true;
        }
        if (!(minValue <= rootNode.getValue() && rootNode.getValue() <= maxValue)) {
            return false;
        }
        return checkIFTreeISBST(minValue, rootNode.getValue(), rootNode.getLeftNode()) && checkIFTreeISBST(rootNode.getValue(), maxValue, rootNode.getRightNode());
    }
}
