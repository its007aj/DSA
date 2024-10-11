/*
https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/description/
*/


class Solution {

    public class Metadata{
        int frndNo;
        int arr;
        int dep;

        Metadata(int n, int a, int d){
            frndNo = n;
            arr = a;
            dep = d;
        }
    }

    public int smallestChair(int[][] times, int targetFriend) {
        Queue<Metadata> arrival = new PriorityQueue<>(
            (a, b) -> a.arr - b.arr
        );

        Queue<Metadata> departure = new PriorityQueue<>(
            (a, b) -> a.dep - b.dep
        );

        Queue<Integer> seat = new PriorityQueue<>();

        for(int i=0; i<times.length; i++){
            arrival.add(new Metadata(i, times[i][0], times[i][1]));
            departure.add(new Metadata(i, times[i][0], times[i][1]));
            seat.add(i);
        }

        Map<Integer, Integer> frndToSeat = new HashMap<>();

        while(!arrival.isEmpty()){
            Metadata m = arrival.poll();
            while(!departure.isEmpty() && departure.peek().dep<=m.arr){
                int frnd = departure.poll().frndNo;
                if(frndToSeat.containsKey(frnd)){
                    seat.add(frndToSeat.get(frnd));
                }
            }
            
            int emptySeat = seat.poll();
            frndToSeat.put(m.frndNo, emptySeat);
            if(m.frndNo==targetFriend)
                return frndToSeat.get(targetFriend);
        }

        return 0;
    }
}
