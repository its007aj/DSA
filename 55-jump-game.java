/*
https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
*/


class Solution {
    public boolean canJump(int[] nums) {
        int count = 0;

        for(int i=nums.length-2; i>=0; i--){

            if(nums[i]==0)
                count++;
            else {
                if(nums[i]<count+1)
                    count++;
                else
                    count = 0;
            }
        }

        if(count==0)
            return true;

        return false;
    }
}
