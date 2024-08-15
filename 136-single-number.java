/*
https://leetcode.com/problems/single-number/description/?envType=study-plan-v2&envId=top-interview-150
*/

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;

        for(int i=0; i<nums.length; i++){
            ans = ans ^ nums[i];
        }

        return ans;
    }
}
