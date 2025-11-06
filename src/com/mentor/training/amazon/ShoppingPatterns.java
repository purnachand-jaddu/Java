package com.mentor.training.amazon;

import java.util.*;

public class ShoppingPatterns {

    // Simple Pair class to replace javafx.util.Pair
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    public static void main(String[] args) {
        int[] startingPoints = new int[]{1, 2, 2, 3, 4, 5};
        int[] endingPoints = new int[]{2, 4, 5, 5, 5, 6};
        System.out.println(getMinSum(6, 6, startingPoints, endingPoints));
    }


    public static int getMinSum(int numberOfNodes, int numberOfEdges, int[] staringPoints, int[] endingPoints) {
        Map<Integer, GraphNode> valueToNodeMap = new HashMap<>();
        for (int i = 1; i <= numberOfNodes; i++) {
            valueToNodeMap.put(i, new GraphNode(i));
        }

        Set<Pair<Integer, Integer>> edges = new HashSet<>();
        for (int i = 0; i < numberOfEdges; i++) {
            int startingPoint = staringPoints[i];
            int endingPoint = endingPoints[i];
            GraphNode startingNode = valueToNodeMap.get(startingPoint);
            GraphNode endingNode = valueToNodeMap.get(endingPoint);
            startingNode.addConnection(endingNode);
            edges.add(new Pair<>(startingPoint, endingPoint));
        }

        Set<Set<Integer>> alreadyFormedTrios = new HashSet<>();
        int totalSum = 0;
        for (Pair<Integer, Integer> edge : edges) {
            GraphNode firstNode = valueToNodeMap.get(edge.getKey());
            GraphNode secondNode = valueToNodeMap.get(edge.getValue());

            for (GraphNode thirdNode : valueToNodeMap.values()) {
                if (firstNode.connections.contains(thirdNode) && secondNode.connections.contains(thirdNode) && !isAlreadyFormedTrio(alreadyFormedTrios, firstNode.value, secondNode.value, thirdNode.value)) {
                    //Trio was formed
                    System.out.println("Trio formed with" + firstNode.value + "," + secondNode.value + "," + thirdNode.value);
                    totalSum += (firstNode.degree + secondNode.degree + thirdNode.degree - 6);
                    Set<Integer> trio = new HashSet<>();
                    trio.add(firstNode.value);
                    trio.add(secondNode.value);
                    trio.add(thirdNode.value);
                    alreadyFormedTrios.add(trio);
                }
            }

        }
        return totalSum;
    }

    private static boolean isAlreadyFormedTrio(Set<Set<Integer>> alreadyFormedTrios, int value, int value1, int value2) {
        for (Set<Integer> trio : alreadyFormedTrios) {
            if (trio.contains(value) && trio.contains(value1) && trio.contains(value2)) {
                return true;
            }
        }
        return false;
    }

    private static class GraphNode {
        private int value;
        private List<GraphNode> connections;
        private int degree;

        private GraphNode(int value) {
            this.value = value;
            this.connections = null;
            this.degree = 0;
        }

        public void addConnection(GraphNode graphNode) {
            if (connections == null) {
                connections = new ArrayList<>();
            }
            if (!connections.contains(graphNode)) {
                connections.add(graphNode);
                degree++;
                graphNode.addConnection(this);
            }
        }
    }
}
