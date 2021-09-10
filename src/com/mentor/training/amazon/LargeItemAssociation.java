package com.mentor.training.amazon;

import java.util.*;

public class LargeItemAssociation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Item> nameToItemMap = new HashMap<>();

        int numberOfPairs = scanner.nextInt();

        for (int i = 0; i < numberOfPairs; i++) {
            String firstItemName = scanner.next();
            String secondItemName = scanner.next();

            Item firstObject = getObjectFromMap(nameToItemMap, firstItemName);
            Item secondObject = getObjectFromMap(nameToItemMap, secondItemName);

            firstObject.addItem(secondObject);
        }

        Set<Item> visitedObjects = new HashSet<>();
        Collection<Item> allItems = nameToItemMap.values();

        int maxSize = Integer.MIN_VALUE;
        List<Item> maxConnectedComponents = null;

        for (Item item : allItems) {
            if (!visitedObjects.contains(item)) {
                List<Item> connectedComponentOfItem = findConnectedComponentOfItem(item, visitedObjects);
                if (connectedComponentOfItem.size() > maxSize) {
                    maxSize = connectedComponentOfItem.size();
                    maxConnectedComponents = connectedComponentOfItem;
                }

            }
        }

        System.out.println(maxConnectedComponents.size());
    }

    private static List<Item> findConnectedComponentOfItem(Item item, Set<Item> visitedObjects) {

        List<Item> connectedComponentItems = new ArrayList<>();

        Queue<Item> itemQueue = new LinkedList<>();

        itemQueue.add(item);

        while (!itemQueue.isEmpty()) {
            Item popedItem = itemQueue.poll();
            visitedObjects.add(popedItem);
            connectedComponentItems.add(popedItem);
            for (Item connection : popedItem.connections) {
                if (!visitedObjects.contains(connection)) {
                    itemQueue.add(connection);
                }
            }
        }
        return connectedComponentItems;
    }

    private static Item getObjectFromMap(Map<String, Item> nameToItemMap, String firstItemName) {
        Item firstObject;
        if (!nameToItemMap.containsKey(firstItemName)) {
            firstObject = new Item(firstItemName);
            nameToItemMap.put(firstItemName, firstObject);
        } else {
            firstObject = nameToItemMap.get(firstItemName);
        }
        return firstObject;
    }


    private static class Item {
        private String name;

        private List<Item> connections;

        private Item(String name) {
            this.name = name;
            this.connections = null;
        }

        private void addItem(Item item) {
            if (connections == null) {
                connections = new ArrayList<>();
            }
            if (!connections.contains(item)) {
                connections.add(item);
                item.addItem(this);
            }

        }

    }

}
