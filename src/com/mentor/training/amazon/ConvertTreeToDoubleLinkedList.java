package com.mentor.training.amazon;

import com.mentor.training.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class ConvertTreeToDoubleLinkedList {

    private static final List<Long> inorderCapture = new ArrayList<>();

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);

        TreeNode treeNode2 = new TreeNode(3);
        treeNode2.setLeftNode(treeNode);
        treeNode2.setRightNode(treeNode1);

        TreeNode treeNode3 = new TreeNode(5);

        TreeNode rootNode = new TreeNode(4);

        rootNode.setLeftNode(treeNode2);
        rootNode.setRightNode(treeNode3);

        inorderCapture.clear();

        captureInorder(rootNode);

        System.out.println(inorderCapture);

    }

    private static void captureInorder(TreeNode rootNode) {

        if (rootNode == null) {
            return;
        }
        captureInorder(rootNode.getLeftNode());
        inorderCapture.add(rootNode.getValue());
        captureInorder(rootNode.getRightNode());
    }
}
