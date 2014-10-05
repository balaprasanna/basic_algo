//trivial
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = head;
        ListNode cur = head;
        int max = head.val;
        while(cur.next!=null){
            if(cur.next.val >= max){
                max = cur.next.val;
                cur = cur.next;
            }
            else if(cur.next.val <= newHead.val){
                ListNode tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = newHead;
                newHead = tmp;
            }else{
                ListNode tmp = newHead;
                while(tmp.next.val < cur.next.val)
                    tmp = tmp.next;
                ListNode ins = cur.next;
                cur.next = ins.next;
                ListNode nxt = tmp.next;
                tmp.next = ins;
                ins.next = nxt;
            }
        }
        return newHead;
    }
}
