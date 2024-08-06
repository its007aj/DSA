/*
https://leetcode.com/problems/ransom-note/description/?envType=study-plan-v2&envId=top-interview-150
*/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        Map<Character, Integer> mag = new HashMap<>();

        for(int i=0; i<magazine.length(); i++){
            char c = magazine.charAt(i);
            mag.put(c, mag.getOrDefault(c, 0)+1);
        }

        for(int i=0; i<ransomNote.length(); i++){
            char c = ransomNote.charAt(i);

            if(!mag.containsKey(c) || mag.get(c)==0)
                return false;
            
            mag.put(c, mag.get(c)-1); 
        }

        return true;

    }
}
