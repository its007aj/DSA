/*
https://leetcode.com/problems/reverse-words-in-a-string/description/
*/


class Solution {
    public String reverseWords(String s) {

        int n = s.length();
        int i = n-1;

        StringBuilder ans = new StringBuilder("");

        while(i>=0){
            StringBuilder temp = new StringBuilder("");
            if(s.charAt(i)==' '){
                i--;
            }
            else if(s.charAt(i)!=' '){
                while(i>=0 && s.charAt(i)!=' '){
                    StringBuilder t = new StringBuilder("" + s.charAt(i));
                    temp = t.append(temp);
                    i--;
                }
                ans.append(temp.append(" "));
                temp = new StringBuilder("");
                i--;
            }
            
        }

        ans.deleteCharAt(ans.length()-1);

        return ans.toString();
        
    }
}
