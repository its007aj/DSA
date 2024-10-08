/*
https://leetcode.com/problems/min-cost-climbing-stairs/description/?envType=problem-list-v2&envId=dynamic-programming&difficulty=EASY
*/

class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length+1];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i=2; i<dp.length-1; i++){
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }

        dp[dp.length-1] = Math.min(dp[dp.length-2], dp[dp.length-3]);

        return dp[dp.length-1];
        
    }
}
