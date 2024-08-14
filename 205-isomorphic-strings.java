/*
https://leetcode.com/problems/isomorphic-strings/description/?envType=study-plan-v2&envId=top-interview-150
*/


class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> m1 = new HashMap<>();
        Map<Character, Character> m2 = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ss = s.charAt(i);
            char tt = t.charAt(i);

            if(!m1.containsKey(ss))
                m1.put(ss, tt);

            if(!m2.containsKey(tt))
                m2.put(tt, ss);

            if(m1.get(ss)!=tt || m2.get(tt)!=ss)
                return false;
        }

        return true;
    }
}
