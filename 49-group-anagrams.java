/*
https://leetcode.com/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-interview-150
*/


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            char[] arr = new String(strs[i]).toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            if(!map.containsKey(s)){
                map.put(s, new ArrayList<>());
            }

            map.get(s).add(strs[i]);
        }

        List<List<String>> ans = new ArrayList<>();
        for(String temp: map.keySet()){
            List<String> l = map.get(temp);
            int n = l.size();
            List<String> tempList = new ArrayList<>();
            for(int i=0; i<n; i++){
                tempList.add(l.get(i));
            }
            ans.add(tempList);
        }

        return ans;
        
    }
}
