/*
https://leetcode.com/problems/word-pattern/description/?envType=study-plan-v2&envId=top-interview-150
*/

class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] w = s.split(" ");
        char[] c = pattern.toCharArray();

        if (w.length != c.length)
            return false;

        Map<Character, String> m1 = new HashMap();
        Map<String, Character> m2 = new HashMap();

        for (int i = 0; i < w.length; i++) {

            if (!m1.containsKey(c[i]))
                m1.put(c[i], w[i]);

            if (!m2.containsKey(w[i]))
                m2.put(w[i], c[i]);

            if (!(m1.get(c[i]).equals(w[i])
                    && m2.get(w[i]).equals(c[i])))
                return false;
        }

        return true;
    }
}
