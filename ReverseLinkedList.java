/*Approach #1 (Iterative)
create a dummy node assign to null
        create a next node and point to head.next
        break this link and point to dummy node that is null
        take thid dummy and point to head

 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = null;

        while(head != null ) {
            ListNode next =  head.next;
            head.next = dummy;
            dummy = head;
            head = next;
        }
        return dummy;
    }
}
/*
        Complexity analysis

        Time complexity : O(n)O(n). Assume that nn is the list's length, the time complexity is O(n)O(n).

        Space complexity : O(1)O(1).

        Approach #2 (Recursive) [Accepted]
        Assume that the rest of the list had already been reversed,
         now how do I reverse the front part? Let's assume the list is: n1 → … → nk-1 → nk → nk+1 → … → nm → Ø
        Assume from node nk+1 to nm had been reversed and you are at node nk.
        n1 → … → nk-1 → nk → nk+1 ← … ← nm
        We want nk+1’s next node to point to nk.
        So,
        nk.next.next = nk;
        Be very careful that n1's next must point to Ø. If you forget about this, your linked list has a cycle in it. This bug could be caught if you test your code with a linked list of size 2.

 */
public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
        }
        /*
        Complexity analysis

        Time complexity : O(n)O(n). Assume that nn is the list's length, the time complexity is O(n)O(n).

        Space complexity : O(n)O(n). The extra space comes from implicit stack space due to recursion. The recursion could go up to nn levels deep.


         */
