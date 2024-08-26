/*
https://leetcode.com/problems/house-robber/description/?envType=study-plan-v2&envId=top-interview-150
*/


class Solution {
    int[] dp;

    public int rob(int[] nums) {
        int n = nums.length;

        // dp = new int[n];

        dp = new int[n+1];

        for(int i=0; i<n; i++){
            dp[i] = -1;
        }

        // solution(n-1, nums);
        dp[0] = 0;
        dp[1] = nums[0];

        for(int i=2; i<n+1; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }

        // return dp[n-1];
        return dp[n];
    }

    public int solution(int i, int[] nums){
        if(i<0)
            return 0;

        if(dp[i]!=-1){
            return dp[i];
        }

        dp[i] = Math.max(solution(i-1, nums), solution(i-2, nums)+nums[i]);

        return dp[i];
    }
}
