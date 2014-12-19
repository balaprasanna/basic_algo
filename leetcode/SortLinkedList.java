//bottom-up merge sort
//2周目，进击的AC
public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        //get the length of list
        int len = 0;
        ListNode cur = head;
        while(cur!=null){
            len++;
            cur = cur.next;
        }
        //bottom-up merge
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        for(int step = 1; step < len; step=step*2){
            ListNode left = dummyHead;
            ListNode right = left;
            while(left.next!=null){
                for(int j = step; j>0 && right.next!=null; j--)
                    right = right.next;
                left = merge(left, right, step);
                right = left;
            }
        }
        return dummyHead.next;
    }
    public ListNode merge(ListNode left, ListNode right, int step){
        if(right.next == null)
            return right;
        ListNode newLeft = right;
        for(int i = step; i > 0 && newLeft.next!=null; i--)
            newLeft = newLeft.next;
        ListNode nextFirst = newLeft.next;
        newLeft.next = null;
        
        ListNode cur = left;
        ListNode lnode = left.next;
        ListNode rnode = right.next;
        right.next = null;
        while(lnode!= null && rnode != null){
            if(lnode.val < rnode.val){
                cur.next = lnode;
                lnode = lnode.next;
                cur = cur.next;
                cur.next = null;
            }
            else{
                cur.next = rnode;
                rnode = rnode.next;
                cur = cur.next;
                cur.next = null;
            }
        }
        if(lnode == null)
            cur.next = rnode;
        else
            cur.next = lnode;
        if(nextFirst != null){
            while(cur.next != null)
                cur = cur.next;
            cur.next = nextFirst;
            return cur;
        }
        return newLeft;
    }
}
