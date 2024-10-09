/*
https://leetcode.com/problems/counting-bits/description/?envType=problem-list-v2&envId=dynamic-programming&difficulty=EASY
*/


class Solution {
    public int[] countBits(int n) {

        int dp[] = new int[n+1];

        dp[0] = 0;

        for(int i=1; i<=n; i++){
            dp[i] = dp[i/2];
            if(i%2 != 0)
                dp[i] += 1;
        }

        return dp;
        
    }
}
