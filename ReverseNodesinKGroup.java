/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next;  * }

 Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

 Follow up:

 Could you solve the problem in O(1) extra memory space?
 You may not alter the values in the list's nodes, only nodes itself may be changed.


 Example 1:


 Input: head = [1,2,3,4,5], k = 2
 Output: [2,1,4,3,5]
 Example 2:


 Input: head = [1,2,3,4,5], k = 3      O(N) O(1)
 Output: [3,2,1,4,5] 2->1 1->3 3->2
 Example 3:

 Input: head = [1,2,3,4,5], k = 1
 Output: [1,2,3,4,5]
 Example 4:

 Input: head = [1], k = 1
 Output: [1]


 Constraints:

 The number of nodes in the list is in the range sz.
 1 <= sz <= 5000
 0 <= Node.val <= 1000
 1 <= k <= sz

 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;
        while (curr!=null){
            count++;//count the size of LL
            curr=curr.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while(count >= k) {
            for (int i = 1; i < k; i++) {
                ListNode next = curr.next.next;

                curr.next.next = prev.next;
                prev.next = curr.next;
                curr.next = next;
            }

            prev = curr;
            curr = curr.next;
            count = count-k;
        }

        return dummy.next;
    }
}