
public class WordDictionary {
	class TrieNode {
	    // Initialize your data structure here.
		TrieNode[] next = new TrieNode[26];
		boolean isWord = false;
	    public TrieNode() {   
	    }
	}
	private TrieNode root;
	public WordDictionary() {
		root = new TrieNode();
	}
	
    // Adds a word into the data structure.
    public void addWord(String word) {
    	TrieNode cur = root;
    	for (int i = 0; i < word.length(); i++) {
    		char ch = word.charAt(i);
    		if (cur.next[ch - 'a'] == null)
    			cur.next[ch - 'a'] = new TrieNode();
    		cur = cur.next[ch - 'a'];
    	}
    	cur.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	return search(word, root, 0);
    }
    private boolean search(String word, TrieNode cur, int start) {
    	if (start == word.length() && cur != null && cur.isWord)
    		return true;
    	if (cur == null)
    		return false;
    	for (int i = start; i < word.length(); i++) {
    		char ch = word.charAt(i);
    		if (ch != '.') {
    			if (cur.next[ch - 'a'] == null)
    				return false;
    			cur = cur.next[ch - 'a'];
    		} else {
    			for (TrieNode t: cur.next) {
    				if (t != null && search(word, t, i + 1))
    					return true;
    			}
    			return false;
    		}
    	}
    	return cur.isWord;  
    }
    public static void main(String[] args) {
    	WordDictionary wordDictionary = new WordDictionary();
    	wordDictionary.addWord("a");
    	wordDictionary.addWord("a");
    	wordDictionary.search(".");
    	wordDictionary.search("a");
    	wordDictionary.search("aa");
    	wordDictionary.search("a");
    	wordDictionary.search(".a");
    	wordDictionary.search("a.");
    	System.out.println(wordDictionary.search("."));
    	System.out.println(wordDictionary.search("a"));
    	System.out.println(wordDictionary.search("aa"));
    	System.out.println(wordDictionary.search("a"));
    	System.out.println(wordDictionary.search(".a"));
    	System.out.println(wordDictionary.search("a."));
    	System.out.println(wordDictionary.search("a.."));
//    	wordDictionary.addWord("word");
//    	System.out.println(wordDictionary.search("pattern"));
//    	System.out.println(wordDictionary.search("word"));
//    	System.out.println(wordDictionary.search(".ord"));
//    	System.out.println(wordDictionary.search("wor."));
//    	System.out.println(wordDictionary.search("wo.d"));
//    	System.out.println(wordDictionary.search("w.rd"));
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");