/*
https://leetcode.com/problems/unique-binary-search-trees/description/
*/


class Solution {
    public int numTrees(int n) {
        int total = 0;
        
        total = numBSTs(n);
        return total;
        
    }

    public int numBSTs(int n){
        // if(n==0 || n==1)
        //     return 1;

        // if(n==2)
        //     return 2;
    
        // int total = 0;

        // for(int root=1; root<=n; root++){
        //     total += numBSTs(root-1)*numBSTs(n-root);
        // }

        // return total;

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int root=2; root<=n; root++){
            int total = 0;
            for(int i=1; i<=root; i++){
                total += dp[i-1]*dp[root-i];
            }
            dp[root] = total;
        }

        return dp[n];
    }
}
