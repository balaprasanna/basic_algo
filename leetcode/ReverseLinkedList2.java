
public class ReverseLinkedList2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) return head;
        //pay attention to one pass
        ListNode fakehead = new ListNode(0);
        fakehead.next = head;
        int counter = 1;
        ListNode pretail = fakehead;
        while(counter < m){
            pretail = pretail.next;
            counter++;
        }
        ListNode cur = null;
        ListNode pre = null;
        ListNode first = pretail.next;
        while(counter < n){
            cur = pretail.next;
            pretail.next = cur.next;
            cur.next = pre;
            pre = cur;
            counter++;
        }
        cur = pretail.next;
        first.next = cur.next;
        cur.next = pre;
        return fakehead.next;
    }
}
