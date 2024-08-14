/*
https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150
*/

class Solution {
    public boolean isPalindrome(String s) {
        List<Character> charList = new ArrayList<>();

        String str = s.toLowerCase();

        for(int i=0; i<s.length(); i++){
            char c = str.charAt(i);

            if(Character.isLetterOrDigit(c))
                charList.add(c);
        }

        int i = 0;
        int j = charList.size()-1;

        while(i<=j){
            if(charList.get(i)!=charList.get(j))
                return false;

            i++;
            j--;
        }
        return true;
    }
}
