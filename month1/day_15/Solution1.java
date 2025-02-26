class Solution1 {
    private static class TrieNode {
        char c;
        TrieNode[] next;
        int wordEnd; // indicates the end of a word and stores the index of the word in the words array

        TrieNode(char c) {
            this.c = c;
            this.next = new TrieNode[26];
            this.wordEnd = -1;
        }
    }

    private final int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    char[][] board;
    String[] words;
    int m, n;

    private void buildTrie(TrieNode root, String word, int i) {
        for(char c: word.toCharArray()) {
            int idx = c - 'a';
            if(root.next[idx] == null) {
                root.next[idx] = new TrieNode(c);
            }
            root = root.next[idx];
        }
        root.wordEnd = i;
    }

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.words = words;
        this.m = board.length;
        this.n = board[0].length;

        TrieNode root = new TrieNode('-');

        for(int i = 0; i < words.length; i++) {
            this.buildTrie(root, words[i], i);
        }

        List<String> ans = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                this.dfs(i, j, root, ans);
            }
        }

        return ans;
    }

    private void dfs(int i, int j, TrieNode root, List<String> ans) {
        char temp = board[i][j];
        board[i][j] = '-';

        // traverse through the trie and search in board only if a character matches
        for(TrieNode next: root.next) {
            if(next == null) continue;
            if(next.c == temp) {
                if(next.wordEnd != -1) {
                    ans.add(words[next.wordEnd]);
                    next.wordEnd = -1; // this ensures same word isn't added twice into ans
                }
                for(int[] dir: dirs) {
                    int r = i + dir[0];
                    int c = j + dir[1];

                    if(check(r, c)) {
                        dfs(r, c, next, ans);
                    }
                }
            }
        }

        board[i][j] = temp;
    }

    private boolean check(int i, int j) {
        return 0 <= i && i < m && 0 <= j && j < n && board[i][j] != '-';
    }
}