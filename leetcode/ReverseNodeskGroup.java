//Reverse Nodes in k-Group 
//recursive
//reverse a linked list, where to store ref information problem
public class ReverseNodeskGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null) return head;
        ListNode newhead = head;
        for (int i = 1; i < k; i++)
            if(newhead.next != null)
                newhead = newhead.next;
            else 
                return head;
        ListNode tail = head;
        ListNode pre = head;
        ListNode cur = head.next;
        for(int i = 1; i < k; i++){
            tail.next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tail.next;
        }
        if(tail.next != null)
            tail.next = reverseKGroup(tail.next, k);
        return newhead;
    }}
