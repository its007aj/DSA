/*
https://leetcode.com/problems/pascals-triangle-ii/description/?envType=problem-list-v2&envId=dynamic-programming&difficulty=EASY
*/


class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[][] dp = new int[rowIndex+1][rowIndex+1];

        dp[0][0] = 1;

        for(int i=1; i<=rowIndex; i++){
            dp[i][0] = 1;
            for(int j=1; j<=i; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int j=0; j<=rowIndex; j++){
            ans.add(dp[rowIndex][j]);
        }

        return ans;
    }
}
