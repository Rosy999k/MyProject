class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }

        int count=1;
        int l = 0, r = n - 1, u = 0, d = n - 1;
        while (count <= n*n) {
            for (int i = l; i <= r && count <= n*n; i++) {
                matrix[u][i]=count++;
            }
            for (int i = u + 1; i <= d - 1&& count <= n*n; i++) {
                matrix[i][r]=count++;
            }
            for (int i = r; i >= l && count <= n*n; i--) {
                matrix[d][i]=count++;
            }
            for (int i = d - 1; i >= u + 1 && count <= n*n; i--) {
                matrix[i][l]=count++;
            }

            l++;
            u++;
            r--;
            d--;
        }
        return matrix;
    }
}