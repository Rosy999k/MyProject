/* dfs if founf grid[i][j] n++ mark to 0 look all sides of i j
O(MN) O(MN)
 */
class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int noOfIslands= 0;
        int cols = grid[0].length;
        if(grid == null || grid.length == 0) return 0;

        for(int i = 0; i<rows; i++)
        {
            for(int j=0; j<cols;j++)
            {
                if(grid[i][j] == '1')
                {
                    noOfIslands++;
                    dfs(grid, i , j);
                }
            }
        }
        return noOfIslands;
    }

    private void dfs(char[][] grid, int i, int j){
        int rows = grid.length;
        int cols = grid[0].length;


        if(i< 0 || j < 0 || i>= grid.length || j>=  grid[0].length || grid[i][j] == '0') return;

        grid[i][j] ='0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}