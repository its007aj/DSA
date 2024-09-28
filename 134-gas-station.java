/*
https://leetcode.com/problems/gas-station/description/?envType=problem-list-v2&envId=greedy&difficulty=MEDIUM
*/


class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int totalGas = 0;
        int requiredGas = 0;
        for(int i=0; i<gas.length; i++){
            totalGas += gas[i];
            requiredGas += cost[i];
        }

        if(totalGas<requiredGas)
            return -1;
        
        int start = 0;
        int remainingFuel = 0;

        for(int i=0; i<gas.length; i++){
            remainingFuel += gas[i]-cost[i];
            if(remainingFuel<0){
                start = i+1;
                remainingFuel = 0;
            }
        }

        return start;

    }
}
