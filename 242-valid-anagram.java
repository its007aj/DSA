/*
https://leetcode.com/problems/valid-anagram/description/?envType=study-plan-v2&envId=top-interview-150
*/


class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> m = new HashMap<>();

        if(s.length()!=t.length())
            return false;

        for(int i=0; i<s.length(); i++){
            m.put(s.charAt(i), 
                    m.getOrDefault(s.charAt(i), 0)+1);
        }

        for(int i=0; i<t.length(); i++){
            if(!m.containsKey(t.charAt(i)))
                return false;

            int count = m.get(t.charAt(i));
            if(count == 0)
                return false;
            m.put(t.charAt(i), count-1);
        }

        for(char key: m.keySet()){
            if(m.get(key)!=0)
                return false;
        }
        
        return true;
    }
}
