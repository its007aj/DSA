/*
https://leetcode.com/problems/longest-common-prefix/description/?envType=study-plan-v2&envId=top-interview-150
*/


class Solution {
    public String longestCommonPrefix(String[] strs) {

        int ans = -1;
        int set = 0;

        if(strs.length==0)
            return "";

        if(strs.length==1)
            return strs[0];

        for(int i=0; i<strs[0].length(); i++){
            char c = strs[0].charAt(i);

            for(int j=1; j<strs.length; j++){
                if(i>=strs[j].length()){
                    set = 0;
                    break;
                }

                if(c!=strs[j].charAt(i)){
                    set = 0;
                    break;
                }

                set = 1;
            }

            if(set==0){
                break;
            }
            else{
                ans++;
                set = 0;
            }
        }

        if(ans==-1)
            return "";
        else
            return strs[0].substring(0, ans+1);
        
    }
}
