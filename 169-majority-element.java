/*
https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
*/

class Solution {

    // Boyer-Moore Majority Voting Algorithm
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 1;

        //finding the candidate
        for(int i=1; i<nums.length; i++){
            if(nums[i]==nums[res])
                count++;
            else 
            count--;

            if(count==0) {
                res = i;
                count = 1;
            }
        }

        //check if majority or not
        count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[res]==nums[i])
                count++;
            
            if(nums[res]>nums.length/2)
                return nums[res];
        }

        return nums[res];
    }
}
