/*
https://leetcode.com/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-interview-150
*/


class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{')
                st.push(c);

            if(c==')'){
                if(!st.isEmpty() && st.peek()=='(')
                    st.pop();
                else
                    return false;
            }

            if(c==']'){
                if(!st.isEmpty() && st.peek()=='[')
                    st.pop();
                else
                    return false;
            }

            if(c=='}'){
                if(!st.isEmpty() && st.peek()=='{')
                    st.pop();
                else
                    return false;
            }
        }

        if(st.size()!=0)
            return false;

        return true;
    }
}
