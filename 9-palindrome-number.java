/*
https://leetcode.com/problems/palindrome-number/description/?envType=study-plan-v2&envId=top-interview-150
*/


class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;

        if(x==0)
            return true;

        int num = reverse(x);

        return num==x;
    }

    public int reverse(int n){
        int ans = 0;

        while(n>0){
            int rem = n%10;
            ans = ans*10 + rem;
            n = n/10;
        }

        return ans;
    }
}
