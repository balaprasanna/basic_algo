//make use of dummy to deal with head cases
//one-time AC
public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode l1, l2;
        while((l1 = pre.next)!=null && (l2=l1.next)!=null){
            pre.next = l2;
            l1.next = l2.next;
            l2.next = l1;
            pre = l1;
        }
        return dummy.next;
    }
}
