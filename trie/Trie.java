package trie;

public class Trie {

    static class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }

        boolean containsKey(char ch) {
            return children[ch - 'a'] != null;
        }

        TrieNode getNextTrieNode(char ch) {
            return children[ch - 'a'];
        }

        void add(char ch) {
            children[ch - 'a'] = new TrieNode();
        }

        void setEnd() {
            isEnd = true;
        }

    }

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     * 
     * @param word
     * @return void
     * 
     *         Time Complexity: O(n), where n is the word length.
     */
    void insert(String word) {

        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.add(ch);
            }
            node = node.getNextTrieNode(ch);
        }
        node.setEnd();
    }

    /**
     * Checks if the word is in the trie.
     * 
     * @param word
     * @return boolean
     * 
     *         Time Complexity: O(n), where n is the word length.
     */

    boolean search(String word) {

        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!node.containsKey(ch))
                return false;

            node = node.getNextTrieNode(ch);
        }

        return node.isEnd;
    }

    /**
     * Checks if there is any word in the trie that starts with the given prefix.
     * 
     * @param prefix
     * @return boolean
     * 
     *         Time Complexity: O(n), where n is the prefix length.
     */

    boolean startsWith(String prefix) {

        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            if (!node.containsKey(ch))
                return false;

            node = node.getNextTrieNode(ch);
        }
        return true;

    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // returns true
        System.out.println(trie.search("app")); // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app")); // returns true
    }

}
