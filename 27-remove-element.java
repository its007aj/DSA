/*
https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length-1;
        int k = 0;

        while(i<=j){
            if(nums[i]==val){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }
            else{
                i++;
                k++;
            }
        }
        return k;
    }
}
