class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
    public TrieNode(){}
}

class WordDictionary {
    TrieNode trie;
    public WordDictionary() {
        trie = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = trie;

        for(char ch : word.toCharArray()) {
            if(!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.endOfWord = true;
    }

    public boolean match(String word, TrieNode node) {
        for(int i = 0; i< word.length();i++) {
            char ch = word.charAt(i);
            if(!node.children.containsKey(ch)) {
                if(ch == '.') {
                    for(char x : node.children.keySet()) {
                        TrieNode child = node.children.get(x);
                        if(match(word.substring(i+1), child)){
                            return true;
                        }
                    }
                }
                return false;
            } else {
                node = node.children.get(ch);
            }
        }
        return node.endOfWord;
    }

    public boolean search(String word) {
        return match(word, trie);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

