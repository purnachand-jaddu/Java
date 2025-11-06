package com.mentor.training;

public class TreeNode {

    private TreeNode leftNode;

    private TreeNode rightNode;

    private long value;

    public TreeNode(long value) {
        this.value = value;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public long getValue() {
        return value;
    }
}
