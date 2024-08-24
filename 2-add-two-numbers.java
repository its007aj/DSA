/*
https://leetcode.com/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-interview-150
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(); // Dummy node to simplify code
        ListNode temp = dummy;

        // Iterate while either list has remaining nodes or there's a carry
        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry; // Start with the carry

            // Add l1's value if it's not null
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add l2's value if it's not null
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10; // Calculate new carry

            // Create a new node with the sum mod 10
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }

        // Return the next of dummy node since the first node is a placeholder
        return dummy.next;
    }
}
