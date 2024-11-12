/*
https://leetcode.com/problems/most-beautiful-item-for-each-query/description/
*/



class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {

        TreeMap<Integer, Integer> priceToBeautyMap = new TreeMap<>();

        int globalMax = 0;
        for(int i=0; i<items.length; i++){
            int price = items[i][0];
            int beauty = items[i][1];
            if(!priceToBeautyMap.containsKey(price))
                priceToBeautyMap.put(price, beauty);
            else{
                int curr = priceToBeautyMap.get(price);
                priceToBeautyMap.put(price, Math.max(beauty, curr));
            }
        }

        for(int key: priceToBeautyMap.keySet()){
            globalMax = Math.max(globalMax, priceToBeautyMap.get(key));
            priceToBeautyMap.put(key, globalMax);
        }

        int[] ans = new int[queries.length];

        for(int i=0; i<queries.length; i++){
            int check = queries[i];
            int key = 0;

            if(priceToBeautyMap.containsKey(check)){
                key = check;
            }
            else if(priceToBeautyMap.lowerKey(check)!=null){
                key = priceToBeautyMap.lowerKey(check);
            }

            if(key!=0){
                ans[i] = priceToBeautyMap.get(key);
            }
        }

        return ans;
    }
}
