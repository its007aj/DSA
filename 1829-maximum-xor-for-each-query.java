/*
https://leetcode.com/problems/maximum-xor-for-each-query/description/
*/



class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {

        List<Integer> ans = new ArrayList<>();

        int maxK = (int)Math.pow(2, maximumBit)-1;
        int xor = 0;
        for(int i=0; i<nums.length; i++){
            xor = xor ^ nums[i];
            int k = calculateK(xor, maxK);
            ans.add(k);
            // System.out.println("k - "+k);
        }

        for(int i=0; i<ans.size(); i++){
            nums[i] = ans.get(ans.size()-i-1);
        }

        return nums;

        
    }

    public int calculateK(int n, int maxK){

        // System.out.println("n maxK - "+n+" "+maxK);
        
        for(int i=0; i<32; i++){
            int a = n & (1<<i);
            int b = maxK & (1<<i);

            if(a!=0 && b!=0 && (a^b)==0){
                maxK = maxK - (1<<i);
                // System.out.println("maxK "+maxK);
            }
        }

        return maxK;
    }
}
