/*
https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii/description/
*/


class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;

        int res = 0;

        int[] bits = new int[32];
        int l = 0;
        int r = 0;

        while(l<=r && r<nums.length){
            setBits(bits, nums[r], 1);
            res = bitsToInt(bits);
            while(l<=r && res>=k){
                ans = Math.min(ans, r-l+1);
                setBits(bits, nums[l], -1);
                res = bitsToInt(bits);
                l++;
            }
            r++;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public void setBits(int[] bits, int n, int diff){

        for(int i=0; i<32; i++){
            if((n & (1<<i)) >= 1)
                bits[i] += diff;
        }

    }

    public int bitsToInt(int[] bits){
        int res = 0;
        for(int i=0; i<32; i++){
            if(bits[i]!=0)
                res += (1<<i);
        }
        return res;
    }
}
