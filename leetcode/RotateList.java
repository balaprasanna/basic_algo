
public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
        if(head == null) return head;
        //if(n == 0) return head;
        int len = 1;
        ListNode tail;
        for(ListNode cur = head; cur.next != null; cur = cur.next){
            len++;
            if(cur.next == null)
                tail = cur;
        }
        int k = n % len;
        if(k == 0) return head;//no shift needed
        ListNode cur = head;
        for(int i = 0; i <k; i++)
            cur = cur.next;
        ListNode point = head;
        while(cur.next!= null){
            cur = cur.next;
            point = point.next;
        }
        cur.next = head;
        head = point.next;
        point.next = null;
        
        return head;
    }
}
