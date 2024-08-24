/*
https://leetcode.com/problems/add-binary/?envType=study-plan-v2&envId=top-interview-150
*/


class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int i = a.length()-1;
        int j = b.length()-1;
        StringBuilder s = new StringBuilder();

        while(i>=0 || j>=0 || carry>0){
            if(i>=0)
                carry += a.charAt(i--) - '0';
            if(j>=0)
                carry += b.charAt(j--) - '0';
            
            s.append(carry%2); //appending will take less time then insert at 0th position at each iteration
            carry = carry/2;
        }

        return s.reverse().toString();


        // char carry = '0';
        // int la = a.length();
        // int lb = b.length();
        // int i = 0;
        // StringBuilder s = new StringBuilder();

        // while(la-i-1>=0 && lb-i-1>=0){
        //     char ca = a.charAt(la-i-1);
        //     char cb = b.charAt(lb-i-1);
        //     System.out.println(ca+" "+cb);
        //     if(ca=='1'){
        //         if(cb=='1'){
        //             if(carry=='1'){
        //                 s.insert(0, '1');
        //                 carry = '1';
        //             }
        //             else if(carry=='0'){
        //                 s.insert(0, '0');
        //                 carry = '1';
        //             }
        //         }
        //         else if(cb=='0'){
        //             if(carry=='1'){
        //                 s.insert(0, '0');
        //                 carry = '1';
        //             }
        //             else if(carry=='0'){
        //                 s.insert(0, '1');
        //                 carry = '0';
        //             }
        //         }
        //     }
        //     else if(ca=='0'){
        //         if(cb=='1'){
        //             if(carry=='1'){
        //                 s.insert(0, '0');
        //                 carry = '1';
        //             }
        //             else if(carry=='0'){
        //                 s.insert(0, '1');
        //                 carry = '0';
        //             }
        //         }
        //         else if(cb=='0'){
        //             if(carry=='1'){
        //                 s.insert(0, '1');
        //                 carry = '0';
        //             }
        //             else if(carry=='0'){
        //                 s.insert(0, '0');
        //                 carry = '0';
        //             }
        //         }
        //     }
        //     i++;
        // }

        // if(la-i-1<0){
        //     while(lb-i-1>=0){
        //         char cb = b.charAt(lb-i-1);
        //         if(cb=='1'){
        //             if(carry=='1'){
        //                 s.insert(0, '0');
        //                 carry = '1';
        //             }
        //             else if(carry=='0'){
        //                 s.insert(0, '1');
        //                 carry = '0';
        //             }
        //         }
        //         else if(cb=='0'){
        //             if(carry=='1'){
        //                 s.insert(0, '1');
        //                 carry = '0';
        //             }
        //             else if(carry=='0'){
        //                 s.insert(0, '0');
        //                 carry = '0';
        //             }
        //         }
        //         i++;
        //     }

        // }

        // if(lb-i-1<0){
        //     while(la-i-1>=0){
        //         char ca = a.charAt(la-i-1);
        //         if(ca=='1'){
        //             if(carry=='1'){
        //                 s.insert(0, '0');
        //                 carry = '1';
        //             }
        //             else if(carry=='0'){
        //                 s.insert(0, '1');
        //                 carry = '0';
        //             }
        //         }
        //         else if(ca=='0'){
        //             if(carry=='1'){
        //                 s.insert(0, '1');
        //                 carry = '0';
        //             }
        //             else if(carry=='0'){
        //                 s.insert(0, '0');
        //                 carry = '0';
        //             }
        //         }
        //         i++;
        //     }
        // }  

        // if(carry=='1'){
        //     s.insert(0, '1');
        // }      

        // return s.toString();
        
    }
}
