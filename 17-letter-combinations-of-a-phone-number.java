/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=top-interview-150
*/


class Solution {
    public Map<Character, List<Character>> map;
    public List<String> ans;

    public List<String> letterCombinations(String digits) {
        
        ans = new ArrayList<>();

        if(digits.length()==0)
            return ans;

        map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        permutation(digits, 0, new StringBuilder());

        return ans;
    }

    public void permutation(String str, int start, StringBuilder s){
        if(start==str.length()){
            ans.add(s.toString());
            return ;
        }

        List<Character> l = map.get(str.charAt(start));
        for(int i=0; i<l.size(); i++){
            s.append(l.get(i));
            permutation(str, start+1, s);
            s.deleteCharAt(start);
        }
    }
}
