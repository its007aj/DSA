/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        int k = 1;

        while(j<nums.length){
            if(nums[i]!=nums[j]){
                i++;
                nums[i] = nums[j];
                k++;
            }
            j++;
        }
        return k;
    }
}
