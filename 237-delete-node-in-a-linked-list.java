/*
https://leetcode.com/problems/delete-node-in-a-linked-list/description/
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        
        ListNode prevNode = null;
        ListNode currNode = node;

        while (currNode.next != null) {
            currNode.val = currNode.next.val;
            prevNode = currNode;
            currNode = currNode.next;
        }
        prevNode.next = null;

    }
}
