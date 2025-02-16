/*
https://leetcode.com/problems/pascals-triangle/description/
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=1; i<=numRows; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            if(i!=1){
                int j = ans.get(i-2).size();
                int k = 1;
                while(k<j){
                    int left = ans.get(i-2).get(k-1);
                    int right = ans.get(i-2).get(k);
                    temp.add(left+right);
                    k++;
                }
                temp.add(1);
            }
            ans.add(temp);
        }

        return ans; 
    }
}
