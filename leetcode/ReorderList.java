import java.util.*;
public class ReorderList {
    class ListNode {
             int val;
             ListNode next;
             ListNode(int x) {
                 val = x;
                 next = null;
            }
        }
    public static void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode mid = findMid(head);
        ListNode second = mid.next;
        mid.next = null;
        second = reverse(second);
        merge(head, second);
    }
    private static ListNode findMid(ListNode h){
        ListNode slow = h, fast = h;
        while(fast.next!=null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private static ListNode reverse(ListNode a){
        if(a == null) return a;
        ListNode newHead = a;
        ListNode cur = a.next;
        while(cur!= null){
            cur.next = a.next;
            cur.next = newHead;
            newHead = cur;
            cur = a.next;
        }
        a.next = null;
        return newHead;
    }
    private static void merge(ListNode a, ListNode b){
        ListNode c1 = a, c2 = b;
        while(c2!=null){
            ListNode tmp = c1.next;
            c1.next = c2;
            c2 = c2.next;
            c1.next.next = tmp;
            c1 = tmp;
        }
    }
}
