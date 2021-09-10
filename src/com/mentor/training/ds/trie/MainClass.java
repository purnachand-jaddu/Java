package com.mentor.training.ds.trie;

public class MainClass {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abcd");
        trie.insert("abcdf");
        System.out.println(trie.search("abcdf"));
        System.out.println(trie.search("def"));
    }
}
