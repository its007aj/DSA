/*
https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/
*/


class Solution {
    public int minChanges(String s) {
        int n = s.length();
        int currLength = 1;
        int i = 1;
        int ans = 0;

        while(i<n){
            if(s.charAt(i-1)!=s.charAt(i)){
                if(currLength%2!=0){
                    ans++;
                    i += 2;
                }
                else{
                    i++;
                }
                currLength = 1;
            }
            else{
                currLength++;
                i++;
            }
        }

        return ans;
    }
}
