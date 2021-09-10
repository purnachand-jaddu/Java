package com.mentor.training.ds.trie;

import java.util.ArrayList;
import java.util.List;

class TrieNode {

    private char nodeChar;

    private List<TrieNode> nodes;

    TrieNode(char c) {
        this();
        nodeChar = c;
    }

    TrieNode() {
        nodes = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            nodes.add(null);
        }
    }

    List<TrieNode> getChildren() {
        return nodes;
    }
}
