
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode lefthead = null, righthead = null;
        ListNode left = null, right = null;
        ListNode cur = head;
        while(cur!= null){
            if(cur.val<x){
                if(lefthead == null){
                    lefthead = cur;
                    left = lefthead;
                    cur = cur.next;
                    left.next = null;
                }else{
                    left.next = cur;
                    left = left.next;
                    cur = cur.next;
                    left.next = null;
                }
            }else{
                if(righthead == null){
                    righthead = cur;
                    right = righthead;
                    cur = cur.next;
                    right.next = null;
                }else{
                    right.next = cur;
                    cur = cur.next;
                    right = right.next;
                    right.next = null;
                }
            }
        }
        if(righthead == null)
            return lefthead;
        if(lefthead == null)
            return righthead;
        left.next = righthead;
        return lefthead;
    }
}
