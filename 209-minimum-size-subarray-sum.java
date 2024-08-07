/*
https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150
*/


class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] pSum = new int[n];
        pSum[0] = nums[0];
        int min = n;

        for(int i=1; i<n; i++){
            pSum[i] = pSum[i-1] + nums[i];
        }

        if(pSum[n-1]<target)
            return 0;

        int i = -1;
        int j = 0;
        int sum = 0;

        while(j<n){
            if(i == -1)
                sum = pSum[j];
            else
                sum = pSum[j] - pSum[i];
            if(sum<target)
                j++;
            if(sum>=target){
                if(min > j - i)
                    min = j - i;
                i++;
            }
        }
        
        while(i<n){
            sum = pSum[n-1] - pSum[i];
            if(sum>=target){
                if(min > j - i)
                    min = j - i;
            }
            i++;
        }

        return min;

    }
}
