
class TrieNode {
    // Initialize your data structure here.
    TrieNode[] next = new TrieNode[26];
    boolean isWord = false;
    public TrieNode() {
        
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.next[ch - 'a'] == null)
                cur.next[ch - 'a'] = new TrieNode();
            cur = cur.next[ch - 'a'];
        }
        cur.isWord = true;
        
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.next[ch - 'a'] == null)
                return false;
            cur = cur.next[ch - 'a'];
        }
        return cur.isWord;   
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (cur.next[ch - 'a'] == null)
                return false;
            cur = cur.next[ch - 'a'];
        }
        return true;
    }
    
    public static void main(String[] args) {
        String[] strs = {"something", "so", "abc"};
        Trie trie = new Trie();
        for (String s: strs) {
            trie.insert(s);
        }
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("ab"));
        trie.insert("ab");
        System.out.println(trie.search("ab"));
        System.out.println(trie.startsWith("ab"));
    }
    
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
