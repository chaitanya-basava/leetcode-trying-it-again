class Solution {
    private final int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    char[][] board;
    String word;
    int m, n;

    private boolean check(int i, int j) {
        return 0 <= i && i < m && 0 <= j && j < n && board[i][j] != '-';
    }

    private boolean dfs(int i, int j, int k) {
        if(board[i][j] != word.charAt(k)) return false;
        if(k == word.length()-1) return true;

        char temp = board[i][j];
        board[i][j] = '-'; // no need to use a separate visited array

        for(int[] dir: dirs) {
            int r = i + dir[0];
            int c = j + dir[1];

            if(check(r, c)) {
                if(dfs(r, c, k+1)) return true;
            }
        }

        board[i][j] = temp;

        return false;
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.m = board.length;
        this.n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dfs(i, j, 0)) return true;
            }
        }

        return false;
    }
}
