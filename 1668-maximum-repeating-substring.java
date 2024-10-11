/*
https://leetcode.com/problems/maximum-repeating-substring/description/
*/


class Solution {
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length();
        int m = word.length();

        if(m>n)
            return 0;

        int maxRepeat = 0;
        int[] dp = new int[n+1];

        for(int i=m; i<=n; i++){
            if(sequence.substring(i-m, i).equals(word)){
                dp[i] = dp[i-m] + 1;
                maxRepeat = Math.max(maxRepeat, dp[i]);
            }
        }

        return maxRepeat;
    }
}
