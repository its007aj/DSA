/*
https://leetcode.com/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-interview-150
*/


class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int lmax = 0;
        int rmax = n-1;
        int l = 1;
        int r = n-2;
        int water = 0;

        while(l<=r){
            if(height[l]>=height[lmax])
                lmax = l;
            if(height[r]>=height[rmax])
                rmax = r;
            if(height[lmax]<height[rmax]){
                water += height[lmax]-height[l];
                l++;
            }
            else{
                water += height[rmax]-height[r];
                r--;
            }
        }

        return water;
        
    }
}
