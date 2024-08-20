/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150
*/


class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int ans = 0;

        int b = 0;
        int s = 1;

        while(s<n){
            int buy = prices[b];
            int sell = prices[s];
            if(ans<sell-buy)
                ans = sell - buy;
            if(buy>sell){
                b = s;
            }
            s++;
        }

        return ans;
        
    }
}
