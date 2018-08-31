/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(-1);
        ListNode curr = sum;
        int carry = 0;

        while (l1 != null && l2 != null ) {
            int added = l1.val + l2.val + carry;
            if (added >= 10) {
                carry = 1;
                added = added % 10;
            } else {
                carry = 0;
            }
            ListNode nextNode = new ListNode(added);
            curr.next = nextNode;
            curr = nextNode;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null) {
            curr.next = l1;
        }

        if (l2 != null) {
            curr.next = l2;
        }
        return sum.next;

    }
}