class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return res;
        }

        int noOfRows = matrix.length;
        int noOfCols = matrix[0].length;
        int up = 0, down = noOfRows-1;
        int left=0, right = noOfCols-1;
        int size = noOfRows*noOfCols;
        while(res.size() < size) {
            for(int i = left; i<=right && res.size()< size ; i++) {
                res.add(matrix[up][i]);
            }
            up++;
            for(int i =up; i<=down && res.size()< size; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            for(int i=right; i>=left && res.size()<size; i--) {
                res.add(matrix[down][i]);
            }
            down--;
            for(int i=down; i>=up && res.size()<size; i--) {
                res.add(matrix[i][left]);
            }

            left++;

        }
        return res;
    }
}