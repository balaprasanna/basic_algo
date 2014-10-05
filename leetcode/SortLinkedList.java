//bottom-up merge sort
//non-recursive way
public class SortLinkedList {
	class Pair {
	      public ListNode head;
	      public ListNode tail;
	      public Pair(ListNode head, ListNode tail) {
	          this.head = head;
	          this.tail = tail;
	      }
	  }    

	  private Pair merge(ListNode l1, ListNode t1, ListNode l2, ListNode t2) {
	        ListNode head, tail;
	        ListNode p1 = l1, p2 = l2;
	        if (l1 == null) return new Pair(l2, t2);
	        if (l2 == null) return new Pair(l1, t1);
	        if (l1.val < l2.val) {
	            head = l1;
	            p1 = p1.next;
	        } else {
	            head = l2;
	            p2 = p2.next;
	        }
	        tail = head;
	        while (p1 != null && p2 != null) {
	            ListNode tmp;
	            if (p1.val < p2.val) {
	                tmp = p1.next;
	                tail.next = p1;
	                p1 = tmp;
	            } else {
	                tmp = p2.next;
	                tail.next = p2;
	                p2 = tmp;
	            }
	            tail = tail.next;
	        }
	        if (p1 != null) {
	            tail.next = p1;
	        } else {
	            tail.next = p2;
	        }
	        while (tail.next != null) 
	            tail = tail.next;

	        return new Pair(head, tail);
	    }
	    private ListNode jump(ListNode start, int len) {
	        ListNode ans = start;
	        for (int i=0; i<len; i++) {
	            if (ans != null) {
	                ans = ans.next;
	            } else {
	                break;
	            }
	        }
	        return ans;
	    }
	    public ListNode sortList(ListNode head) {
	        int len = 1;
	        ListNode fstHead, fstTail, sndHead, sndTail, lBound, rBound, dummyHead;
	        boolean changed = true;
	        dummyHead = new ListNode(0);
	        dummyHead.next = head;
	        while (changed) {
	            changed = false;
	            lBound = dummyHead;
	            fstHead = jump(lBound, 1);
	            fstTail = jump(fstHead, len-1);
	            sndHead = jump(fstTail, 1);
	            sndTail = jump(sndHead, len-1);
	            rBound = jump(sndTail, 1);

	            while (sndHead != null) {
	                changed = true;
	                if (fstTail != null) fstTail.next = null;
	                if (sndTail != null) sndTail.next = null;
	                Pair p = merge(fstHead, fstTail, sndHead, sndTail);
	                if (lBound != null) lBound.next = p.head;
	                if (p.tail != null) p.tail.next = rBound;
	                lBound = p.tail;
	                fstHead = jump(lBound, 1);
	                fstTail = jump(fstHead, len-1);
	                sndHead = jump(fstTail, 1);
	                sndTail = jump(sndHead, len-1);
	                rBound = jump(sndTail, 1);
	            }

	            len *= 2;
	        }

	        return dummyHead.next;
	    }
}
