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
	//2nd time
	public ListNode insertionSortList2(ListNode head) {
	        if(head == null || head.next == null) return head;
	        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
	        dummyHead.next = head;
	        ListNode rem = head.next;
	        head.next = null;
	        while(rem != null){
	            ListNode cur = rem;
	            rem = rem.next;
	            cur.next = null;
	            ListNode pos = dummyHead;
	            while(pos.next!= null){
	                if(pos.val <= cur.val && cur.val <= pos.next.val){
	                    cur.next = pos.next;
	                    pos.next = cur;
	                    break;
	                }
	                else{
	                    pos = pos.next;
	                    if(pos.next == null){
	                        pos.next = cur;
	                        break;
	                    }
	                }
	            }
	        }
	        return dummyHead.next;
	    }
	//3rd time
	public ListNode insertionSortList3(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = head;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = null;
            dummyHead = insert(dummyHead, cur);
            cur = next;
        }
        return dummyHead.next;
    }
    private ListNode insert(ListNode h, ListNode c){
        ListNode a = h;
        while(a.next != null && a.next.val < c.val)
            a = a.next;
        if(a.next != null){
            ListNode tmp = a.next;
            a.next = c;
            c.next = tmp;
        }else{
            a.next = c;
        }
        return h;
    }
}
