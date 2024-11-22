/*
https://leetcode.com/problems/shortest-common-supersequence/description/
*/

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        String lcs = findLcs(str1, str2);
        int lcsLength = lcs.length();
        StringBuilder scs = new StringBuilder();

        if(lcsLength==0){
            return str1+str2;
        }

        int i = 0;
        int j = 0;
        for(int k=0; k<lcsLength; k++){
            while(i<str1.length() && str1.charAt(i)!=lcs.charAt(k)){
                scs.append(str1.charAt(i));
                i++;
            }

            while(j<str2.length() && str2.charAt(j)!=lcs.charAt(k)){
                scs.append(str2.charAt(j));
                j++;
            }

            scs.append(lcs.charAt(k));
            i++;
            j++;
        }

        while(i<str1.length()){
            scs.append(str1.charAt(i++));
        }

        while(j<str2.length()){
            scs.append(str2.charAt(j++));
        }

        return scs.toString();
    }

    public String findLcs(String text1, String text2){
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        if(dp[n][m]==0){
            return new String();
        }

        int i = n;
        int j = m;
        StringBuilder lcs = new StringBuilder();
        while(i>=1 && j>=1){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                lcs.append(text1.charAt(i-1));
                i = i-1;
                j = j-1;
            }
            else if(dp[i-1][j]>=dp[i][j-1]){
                i = i-1;
            }
            else if(dp[i-1][j]<dp[i][j-1]){
                j = j-1;
            }
        }

        return lcs.reverse().toString();
    }
}
