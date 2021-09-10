package com.mentor.training.questions;

import java.util.*;

public class OpenTheLock {

    public static int openLock(String[] deadends, String target) {
        String s = "0000";
        Node rootNode = new Node(s);
        Map<String, Node> map = new HashMap<>(10000);
        populateChildren(rootNode, map);
        return 1;
    }

    private static void populateChildren(Node rootNode, Map<String, Node> map) {
        System.out.println(rootNode.value);
        if (map.get(rootNode.value) != null) {
            return;
        }
        map.put(rootNode.value, rootNode);
        List<String> children = new ArrayList<>();
        for (int i = 3; i >= 0; i--) {
            int left = -1;
            int right = -1;
            int value = rootNode.value.charAt(i) - '0';
            if (value == 0) {
                left = 9;
                right = 1;
            } else if (value == 9) {
                left = 8;
                right = 0;
            } else {
                left = value - 1;
                right = value + 1;
            }
            StringBuilder sb = new StringBuilder(rootNode.value);
            sb.setCharAt(i, (char) (left + '0'));
            children.add(sb.toString());
            sb.setCharAt(i, (char) (right + '0'));
            children.add(sb.toString());
        }
        List<Node> nodeChildren = new ArrayList<>();
        for (String child : children) {
            Node node = map.get(child);
            if (node == null) {
                node = new Node(child);
            }
            nodeChildren.add(node);
        }
        rootNode.friends = nodeChildren;
        for (Node childNode : nodeChildren) {
            if (childNode != null) {
                populateChildren(childNode, map);
            }
        }
    }


    static class Node {
        String value;
        List<Node> friends = null;

        Node(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        openLock(new String[0], "1111");
    }
}
