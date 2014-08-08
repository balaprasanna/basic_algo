/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RemoveDupFromLinkedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        while(cur!= null && cur.next !=null ){
            if (cur.val == cur.next.val)
                cur.next = cur.next.next;
            else cur = cur.next;
        }
        return head;
    }
}