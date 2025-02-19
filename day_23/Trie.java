class Trie {
    private static class TrieNode {
        char c;
        boolean end;
        TrieNode[] nodes;

        TrieNode(char c) {
            this.c = c;
            this.end = false;
            this.nodes = new TrieNode[26];
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode('-');
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()) {
            int idx = c - 'a';
            if(node.nodes[idx] == null) {
                node.nodes[idx] = new TrieNode(c);
            }
            node = node.nodes[idx];
        }
        node.end = true;
    }

    private TrieNode findEndNode(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()) {
            int idx = c - 'a';
            if(node.nodes[idx] == null) {
                return null;
            }
            node = node.nodes[idx];
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode lastNode = findEndNode(word);
        return !(lastNode == null || !lastNode.end);
    }

    public boolean startsWith(String prefix) {
        TrieNode lastNode = findEndNode(prefix);
        return lastNode != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */