/**
 create a dummy node. dummy next = heafd, point to slow and fast
 move fast pointer n steps
 until fast reaches null move fast and slow pointer 1 step further
 delete the slow next pointer and point to next next

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode fast = start;
        ListNode slow = start;
        //fast pointer moving n steps
        for(int i=1; i<=n; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            fast=fast.next;
            slow=slow.next;
        }
        //removing the node after slow
        slow.next = slow.next.next;
        return start.next;
    }
}
