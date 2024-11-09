/*
https://leetcode.com/problems/minimum-array-end/description/
*/



class Solution {
    public long minEnd(int n, int x) {
        long ans = x;
        long i_x = 1;
        long i_n = 1; //n-1

        while(i_n<=n-1){
            if((i_x & x) == 0){
                if((i_n & (n-1)) != 0 ){
                    ans = ans | i_x;
                }
                i_n = i_n << 1;
            }
            i_x = i_x << 1;
        }

        return ans;

    }
}
