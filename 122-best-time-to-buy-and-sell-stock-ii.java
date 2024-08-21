/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/?envType=study-plan-v2&envId=top-interview-150
*/


class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = 0;

        int b = 0;
        int s = 0;

        for(s=1; s<n; s++){
            int diff = prices[s]-prices[b];

            if(diff<=0){
                b = s;
            }
            else if((s<n-1 && prices[s]>prices[s+1]) || s==n-1){
                ans += diff;
                b = s+1;
            }

        }  

        return ans;
    }
}
