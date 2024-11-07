/*
https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/
*/


class Solution {
    public int largestCombination(int[] candidates) {
        
        int ans = 0;

        for(int j=0; j<32; j++){
            int temp = 0;
            for(int i=0; i<candidates.length; i++){
                int e = candidates[i];
                if((e & 1<<j)>0){
                    temp++;
                }
            }
            ans = Math.max(temp, ans);
        }
        return ans;
    }
}
