package com.mentor.training.amazon;

import java.util.Arrays;
import java.util.List;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        System.out.println(findDistanceInTree(Arrays.asList(3, 2, 1), 1, 2));
    }

    public static int findDistanceInTree(List<Integer> nodes, int node1, int node2) {
        TreeNode head = null;
        for (int node : nodes) {
            head = insertIntoBST(head, node);
        }
        TreeNode leastCommonAncestor = findLeastCommonAncestor(head, node1, node2);
        return findDistanceFromNode(leastCommonAncestor, node1) + findDistanceFromNode(leastCommonAncestor, node2);
    }

    private static int findDistanceFromNode(TreeNode node, int node1) {
        if (node.value == node1) {
            return 0;
        }
        int distance = 0;
        TreeNode currentNode = node;
        while (true) {
            if (node1 > currentNode.value) {
                distance++;
                currentNode = currentNode.rightNode;
            } else if (node1 < currentNode.value) {
                currentNode = currentNode.leftNode;
                distance++;
            } else {
                break;
            }
        }
        return distance;
    }

    private static TreeNode findLeastCommonAncestor(TreeNode head, int node1, int node2) {
        if (node1 < head.value && node2 < head.value) {
            return findLeastCommonAncestor(head.leftNode, node1, node2);
        }
        if (node1 > head.value && node2 > head.value) {
            return findLeastCommonAncestor(head.rightNode, node1, node2);
        }
        if (head.value == node1 || head.value == node2) {
            return head;
        }
        return head;
    }

    private static TreeNode insertIntoBST(TreeNode head, int value) {
        if (head == null) {
            return new TreeNode(value);
        }
        TreeNode currentNode = head;
        while (true) {
            if (value > currentNode.value) {
                if (currentNode.rightNode == null) {
                    currentNode.rightNode = new TreeNode(value);
                    break;
                } else {
                    currentNode = head.rightNode;
                }
            } else {
                if (currentNode.leftNode == null) {
                    currentNode.leftNode = new TreeNode(value);
                    break;
                } else {
                    currentNode = head.leftNode;
                }
            }
        }
        return head;
    }

    private static class TreeNode {
        private TreeNode leftNode = null;
        private TreeNode rightNode = null;
        private int value;

        private TreeNode(int value) {
            this.value = value;
        }
    }
}
