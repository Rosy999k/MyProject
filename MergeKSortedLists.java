/** Brute : iterating all the nodes and add to arraylist. collections.sort and add creata a new linked list O(NlogN)
 * Better : compare 3 values and add to dummy.next T(NK) size of list SO(N)
 * Optimal : Combine two lists and again combine recursively SO(1)
 * Definition for singly-linked list.
 * public class ListNode { 1 2 3
 *     int val;            1 3 4
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) {
            return null;
        }
        if (lists.length==1){
            return lists[0];
        }
        if (lists.length==2){
            return  mergeTwoLists(lists[0], lists[1]);
        }
        ListNode[] l1 = Arrays.copyOfRange(lists, 0, (lists.length + 1)/2);
        ListNode[] l2 = Arrays.copyOfRange(lists, (lists.length + 1)/2, lists.length);
        return mergeTwoLists(mergeKLists(l1),mergeKLists(l2));
    }
    /*
     * Create a preHead (-1) to keep track of result link list, create l to iterate prehead
     * loop through l1&&L2 not null
     *  if l1 val is less than or equal l2 val, assign l1 to l.next..i.e l1.next=l1,else l.next=l2
     * After the loop check l1or l2 null, if l1 is null l.next=l2, else l.next =l1
     * return preHead.next(Don't return l beacuse l is used only for iteration when it reaches end its val is null)
     * Time complexity : O(n + m)
     * Space complexity : O(1)
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);
        ListNode l = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l.next = l1;
                l1 = l1.next;
            } else {
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        if(l1!=null){
            l.next=l1;
        }else{
            l.next=l2;
        }

        return prehead.next;
    }
}

//class Solution {
//    public ListNode mergeKLists(ListNode[] lists) {
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        for(ListNode head : lists) {
//            while(head != null) {
//                minHeap.add(head.val);
//                head = head.next;
//            }
//        }
//
//        ListNode dummy = new ListNode(-1);
//        ListNode head = dummy;
//        while(!minHeap.isEmpty()){
//            head.next = new ListNode(minHeap.remove());
//            head = head.next;
//        }
//        return dummy.next;
//    }
//}