package com.caffeaulait.problemset;

public class _0208_ImplementTrie {
    /**
     * Implement a trie with insert, search, and startsWith methods.
     *
     * Example:
     *
     * Trie trie = new Trie();
     *
     * trie.insert("apple");
     * trie.search("apple");   // returns true
     * trie.search("app");     // returns false
     * trie.startsWith("app"); // returns true
     * trie.insert("app");
     * trie.search("app");     // returns true
     * Note:
     *
     * You may assume that all inputs are consist of lowercase letters a-z.
     * All inputs are guaranteed to be non-empty strings.
     */

    /** Initialize your data structure here. */
    private TrieNode root;

    public _0208_ImplementTrie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i =0; i < word.length();i++){
            char c = word.charAt(i);
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node!=null && node.isEnd();
    }

    public TrieNode searchPrefix(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length();i++){
            char c = word.charAt(i);
            if (node.containsKey(c)) {
                node = node.get(c);
            }else{
                return null;
            }
        }
        return node;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node!=null;
    }

    class TrieNode {
        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        public TrieNode(){
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch){
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch){
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node){
            links[ch - 'a'] = node;
        }

        public void setEnd(){
            isEnd= true;
        }

        public boolean isEnd(){
            return isEnd;
        }
    }
}
