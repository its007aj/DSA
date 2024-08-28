/*
https://leetcode.com/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=top-interview-150
*/


class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            new Comparator<Integer>(){
                @Override
                public int compare(Integer a, Integer b){
                    if(a<b)
                        return 1;
                    else if(a>b)
                        return -1;
                    else
                        return 0;
                }
            }
        );

        for(int i=0; i<nums.length; i++){
            maxHeap.add(nums[i]);
        }

        for(int i=1; i<k; i++){
            maxHeap.poll();
        }

        return maxHeap.peek();
    }
}
