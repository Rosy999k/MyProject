/*DFS O(N) no of cells S O(N)
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int count, String word) {
        if (count == word.length()) {
            return true;
        }
    //check boundaries
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != word.charAt(count)) {
            return false;
        }

        count++;
        char temp = board[i][j]; // to remember the value
        board[i][j] = ' ';
        boolean found = dfs(board, i + 1, j, count, word) ||
                dfs(board, i - 1, j, count, word) ||
                dfs(board, i, j + 1, count, word) ||
                dfs(board, i, j - 1, count, word);
        board[i][j] = temp;
        return found;
    }
}