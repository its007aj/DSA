/*
https://leetcode.com/problems/single-number-ii/description/?envType=study-plan-v2&envId=top-interview-150
*/


class Solution {
    public int singleNumber(int[] nums) {
        
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums)
                sum += num >> i & 1;
            sum %= 3;
            ans |= sum << i;
        }

        return ans;
  
    }
}
