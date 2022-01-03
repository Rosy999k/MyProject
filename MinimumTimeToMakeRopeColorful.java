class Solution {
    public int minCost(String colors, int[] neededTime) {
         int n = colors.length();
        int result = 0;
        for(int i = 0; i<n-1;i++){
            if(colors.charAt(i) == colors.charAt(i+1)) {
                result = result+ Math.min(neededTime[i], neededTime[i+1]);
                neededTime[i+1]=Math.max(neededTime[i], neededTime[i+1]);
            }
        }
        return result;
    }
}