/*
https://leetcode.com/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-interview-150
*/


class Solution {
    public int[][] merge(int[][] intervals) {
        intervals = sort(intervals);

        int n = intervals.length;
        if(n == 1)
            return intervals;

        Stack<int[]> s = new Stack<>();
        int i = 0;
        s.push(intervals[i++]);

        while(i<n){
            int[] a = s.pop();
            int[] b = intervals[i];

            if(b[0] <= a[1]){
                int[] c = new int[2];
                if(b[1] <= a[1]){
                    c[0] = a[0];
                    c[1] = a[1];
                }
                else if(b[1] > a[1]){
                    c[0] = a[0];
                    c[1] = b[1];
                }
                s.push(c);
            }
            else{
                s.push(a);
                s.push(b);
            }
            i++;
        }

        int[][] ans = new int[s.size()][2];
        int j = 0;
        while(s.size()>0){
            ans[j++] = s.pop();
        }

        return ans;
        
    }

    public int[][] sort(int[][] arr){
        List<List<Integer>> l = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(arr[i][0]);
            temp.add(arr[i][1]);
            l.add(temp);
        }

        Collections.sort(l, new Comparator<List<Integer>>(){
            @Override
            public int compare(List<Integer> a, List<Integer> b){
                if(a.get(0)<b.get(0))
                    return -1;
                else if(a.get(0)>b.get(0))
                    return 1;
                else
                    return 0;
            }
        });

        int[][] ans = new int[arr.length][2];
        for(int i=0; i<arr.length; i++){
            ans[i][0] = l.get(i).get(0);
            ans[i][1] = l.get(i).get(1);
        }

        return ans;
    }
}
