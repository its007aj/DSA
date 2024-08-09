/*
https://leetcode.com/problems/linked-list-cycle/description/?envType=study-plan-v2&envId=top-interview-150
*/


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;
        
        while(slow!=null && fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}
