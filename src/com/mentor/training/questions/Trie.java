package com.mentor.training.questions;

class Trie {

    private Trie[] children = new Trie[26];
    private boolean endsHere = false;

    /** Initialize your data structure here. */
    private Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(this,0,word);
        System.out.println("Inserted " + word);
    }

    private void insert(Trie trie,int index,String word)
    {
        if(index >= word.length())
        {
            return;
        }
        int nodeIndex = word.charAt(index) - 'a';
        if(trie.children[nodeIndex] == null)
        {
            trie.children[nodeIndex] = new Trie();
            if(index == word.length()-1)
            {
                trie.endsHere = true;
            }
        }
        insert(trie.children[nodeIndex],index+1,word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        boolean b = search(this,0,word);
        System.out.println("Searched " + word);
        return b;
    }

    private boolean search(Trie trie,int index,String word)
    {
        int nodeIndex = word.charAt(index) - 'a';
        if(trie.children[nodeIndex] == null)
        {
            return false;
        }
        if(index == word.length()-1)
        {
            return trie.children[nodeIndex].endsHere;
        }
        return search(trie.children[nodeIndex],index+1,word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        boolean b = startsWith(this,0,prefix);
        System.out.println("Starts with called on " + prefix);
        return b;

    }


    private boolean startsWith(Trie trie,int index,String prefix)
    {
        int nodeIndex = prefix.charAt(index) - 'a';
        if(trie.children[nodeIndex] == null)
        {
            return false;
        }
        if(nodeIndex == prefix.length()-1)
        {
            return true;
        }
        return startsWith(trie.children[nodeIndex],index++,prefix);
    }
}