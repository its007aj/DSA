/*
https://leetcode.com/problems/find-peak-element/description/?envType=study-plan-v2&envId=top-interview-150
*/


class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int peak = 0;
        int l=0;
        int hi = n-1;

        if(n==1)
            return n-1;

        while(l<=hi){
            peak = l+(hi-l)/2;
            System.out.println(peak);
            if(peak==0){
                if(nums[peak]>nums[peak+1])
                    break;
                else
                    l = peak+1;
            }
            else if(peak==n-1){
                if(nums[peak]>nums[peak-1])
                    break;
                else
                    hi= peak-1;
            }
            else if(nums[peak-1]<nums[peak] && nums[peak]<nums[peak+1])
                l = peak+1;
            else if(nums[peak-1]>nums[peak] && nums[peak]>nums[peak+1])
                hi = peak-1;
            else if(nums[peak-1]>nums[peak] && nums[peak]<nums[peak+1])
                hi = peak-1;
            else break;
            
        }

        return peak;
    }
}
