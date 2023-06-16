package trie;

public class Trie2 {

    static class TrieNode2 {
        TrieNode2[] children;
        int countEndsWith;
        int countPrefix;

        TrieNode2() {
            this.children = new TrieNode2[26];
            this.countEndsWith = 0;
            this.countPrefix = 0;
        }

        boolean containsKey(char ch) {
            return children[ch - 'a'] != null;
        }

        TrieNode2 getNextTrieNode2(char ch) {
            return children[ch - 'a'];
        }

        void add(char ch) {
            children[ch - 'a'] = new TrieNode2();
        }

        void increaseEnd() {
            countEndsWith++;
        }

        void increasePrefix() {
            countPrefix++;
        }

        void decreaseEnd() {
            if (countEndsWith <= 0)
                return;
            countEndsWith--;
        }

        void decreasePrefix() {
            if (countPrefix <= 0)
                return;
            countPrefix--;
        }

    }

    TrieNode2 root;

    public Trie2() {
        this.root = new TrieNode2();
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

        TrieNode2 node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.add(ch);

            }
            node = node.getNextTrieNode2(ch);
            node.increasePrefix();

        }
        node.increaseEnd();
    }

    /**
     * Counts the number of times a word is in the trie.
     * 
     * @param word
     * @return int count
     * 
     *         Time Complexity: O(n), where n is the word length.
     */
    int countWordsEqualTo(String word) {
        TrieNode2 node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                return 0;
            }
            node = node.getNextTrieNode2(ch);
        }
        return node.countEndsWith;
    }

    /**
     * Counts the number of words that have the given prefix.
     * 
     * @param prefix
     * @return int count
     * 
     *         Time Complexity: O(n), where n is the prefix length.
     */

    int countWordsStartingWith(String prefix) {
        TrieNode2 node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!node.containsKey(ch)) {
                return 0;
            }
            node = node.getNextTrieNode2(ch);
        }
        return node.countPrefix;
    }

    /**
     * Erases a word from the trie.
     * 
     * @param word
     * @return void
     * 
     *         Time Complexity: O(n), where n is the word length.
     */

    void erase(String word) {
        if (countWordsEqualTo(word) == 0)
            return;
        TrieNode2 node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            node = node.getNextTrieNode2(ch);
            node.decreasePrefix();
        }

        node.decreaseEnd();
    }

    public static void main(String[] args) {
        Trie2 trie = new Trie2();
        trie.insert("apple");
        trie.insert("apple");

        trie.insert("app");
        trie.insert("apps");

        System.out.println("***********");
        System.out.println(trie.countWordsEqualTo("apple"));
        System.out.println(trie.countWordsStartingWith("app"));
        trie.erase("app");
        System.out.println(trie.countWordsStartingWith("app"));
        System.out.println(trie.countWordsEqualTo("apple"));
        System.out.println(trie.countWordsEqualTo("apps"));
        System.out.println(trie.countWordsStartingWith("apps"));
        System.out.println(trie.countWordsStartingWith("ap"));
    }

}
