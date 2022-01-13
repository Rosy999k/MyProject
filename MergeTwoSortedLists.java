/**
 Brute : l1 l2 create dummy node, create a mew ll compare and add tp new LL dummy.next  TC(N1+N2) SC(N1+N2)
 Optimal : l1,l2 whichver smaller point to l1 SCO(1)
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res=new ListNode(-1);
        ListNode l=res;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                l.next=l1;
                l1=l1.next;
            }else{
                l.next=l2;
                l2=l2.next;
            }

            l=l.next;
        }

        if(l1!=null){
            l.next=l1;
        }else{
            l.next=l2;
        }

        return res.next;
    }
}