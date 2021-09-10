package com.mentor.training.ds.trie;

class Trie {

    private TrieNode rootNode;

    Trie() {
        rootNode = new TrieNode();
    }

    void insert(String s) {
        TrieNode currentNode = rootNode;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int index = currentChar - 'a';
            TrieNode trieNode = currentNode.getChildren().get(index);
            if (trieNode == null) {
                TrieNode newNode = new TrieNode(currentChar);
                currentNode.getChildren().set(index, newNode);
            }
            currentNode = currentNode.getChildren().get(index);
        }
    }

    boolean search(String s) {
        TrieNode currentNode = rootNode;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int index = currentChar - 'a';
            TrieNode trieNode = currentNode.getChildren().get(index);
            if (trieNode == null) {
                return false;
            }
            currentNode = trieNode;
        }
        return true;
    }
}
