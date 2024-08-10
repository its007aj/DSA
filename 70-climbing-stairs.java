/*
https://leetcode.com/problems/climbing-stairs/description/?envType=study-plan-v2&envId=top-interview-150
*/


class Solution {
    public int climbStairs(int n) {
        int f0 = 1;
        int f1 = 1;

        for(int i = 2; i<=n; i++){
            int temp = f0;
            f0 = f1;
            f1 = temp+f0;
        }

        return f1;
    }
}
