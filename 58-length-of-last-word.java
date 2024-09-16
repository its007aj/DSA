/*
https://leetcode.com/problems/length-of-last-word/?envType=study-plan-v2&envId=top-interview-150
*/


class Solution {
    public int lengthOfLastWord(String s) {

        int n = s.length();
        int ans = 0;
        int space = 1;

        for(int i=n-1; i>=0; i--){
            char c = s.charAt(i);
            if(c==' ' && space==1)
                continue;
            else if(c==' ' && space!=1)
                break;
            else{
                ans++;
                space = 0;
            }
        }
        
        return ans;
    }
}
