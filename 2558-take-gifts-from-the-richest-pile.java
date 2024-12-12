/*
https://leetcode.com/problems/take-gifts-from-the-richest-pile/
*/

class Solution {
    public long pickGifts(int[] gifts, int k) {

        PriorityQueue<Long> pq = new PriorityQueue<>(
            (a, b) -> b.compareTo(a)
        );
        long ans = 0;

        for(int i=0; i<gifts.length; i++){
            pq.add(Long.valueOf(gifts[i]));
        }

        while(k>=1){
            long max = pq.poll();
            long sqrt = (long)Math.sqrt(max);
            pq.add(sqrt);
            k--;
        }

        while(pq.size()!=0){
            ans += pq.poll();
        }

        return ans;
    }
}
