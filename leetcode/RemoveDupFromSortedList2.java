
public class RemoveDupFromSortedList2 {
	if(head== null || head.next == null) return head;
    ListNode cur = head;
    head = null;
    int counter = 0;
    while(cur.next != null){
        if(cur.val != cur.next.val){
            if(counter == 0){
                head = cur;
                break;
            }else{
                counter = 0;
                cur = cur.next;
            }
        }else {
            counter++;
            cur = cur.next;
        }
    }
    if(counter == 0)
        head = cur;
    if(head == null|| head.next == null)
        return head;
    else
        cur = head.next;
    ListNode pre = head;
    pre.next = null;
    counter = 0;
    while(cur.next!= null){
        if(cur.val != cur.next.val){
            if(counter == 0){
                pre.next = cur;
                pre = pre.next;
                cur = cur.next;
                pre.next = null;
            }else{
                counter = 0;
                cur = cur.next;
            }
        }else{
            counter ++;
            cur = cur.next;
        }
    }
    if(counter == 0)
        pre.next = cur;
    return head;
}
}
