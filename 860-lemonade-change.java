/*
https://leetcode.com/problems/lemonade-change/description/
*/

class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        int[] billCount = new int[2];

        billCount[0] = 0;
        billCount[1] = 0;

        for(int i=0; i<bills.length; i++){
            int bill = bills[i];
            if(bill>5){
                int diff = bill-5;
                while(diff>=10 && billCount[1]>0){
                    diff -= 10;
                    billCount[1]--;
                }
                while(diff>=5 && billCount[0]>0){
                    diff -= 5;
                    billCount[0]--;
                }
                
                if(diff>0)
                    return false;
            }
            if(bill==5)
                billCount[0]++;
            if(bill==10)
                billCount[1]++;
        }
        
        return true;

    }
}
