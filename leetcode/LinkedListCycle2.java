//怒AC，有点麻烦
public class LinkedListCycle2 {
	public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!= null && fast.next.next!= null && slow.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                //Test result: there is a cycle!
                int len = 1;
                ListNode cur = fast;
                while(cur.next != fast)
                    {len++; cur = cur.next;}
                //cycle's length: len
                if(len == 1) return fast;
                cur = head;
                int ctr = len-1;
                ListNode p = null;
                while(cur.next != fast){
                    cur = cur.next;
                    if(len > 0)
                        len --;
                    if(len == 0){
                        if(p == null)
                            p = head;
                        else
                            p = p.next;
                    }
                }
                if(len > 0)
                    p = head;
                //p's initialization finished
                ListNode checker = null;
                cur = p;
                while(cur.next!= null){
                    checker = p;
                    while(true){
                        if(checker == cur.next)
                            return checker;
                        if(checker == cur) break;
                        checker = checker.next;
                    }
                    cur = cur.next;
                }
            }
        }
        return null;
    }
	//second attempt, worked it out myself, bravo
	public ListNode detectCycle2(ListNode head) {
	        if(head == null) return null;
	        ListNode s = head, f = head;
	        while(f.next != null && f.next.next != null){
	            s = s.next;
	            f = f.next.next;
	            if(s == f) {
	                ListNode cur = head;
	                while(cur != s){
	                    cur = cur.next;
	                    s = s.next;
	                }
	            return cur;
	            }
	        }
	        return null;
	        
	}
}
