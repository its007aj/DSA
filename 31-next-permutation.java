/*
https://leetcode.com/problems/next-permutation/description/
*/




class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        for(int i=n-2; i>=0; i--) {
            if(nums[i]<nums[i+1]) {
                idx = i;
                break;
            }
        }

        if(idx != -1) {
            for (int i=n-1; i>idx; i--) {
                if(nums[i]>nums[idx]){
                    swap(i, idx, nums);
                    break;
                }
            }
            reverse(idx+1, n-1, nums);
        }
        else {
            reverse(0, n-1, nums);
        }
    
    }

    public void reverse(int start, int end, int[] arr) {
        while(start <= end) {
            swap(start, end, arr);
            start++;
            end--;
        }
    }

    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
