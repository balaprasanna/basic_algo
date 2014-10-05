//easy
public class CopyListWithRandomPtr {
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        HashMap<Integer, RandomListNode> hmap = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.label);
        hmap.put(head.label, newHead);
        RandomListNode cur = newHead;
        RandomListNode pre = head;
        while(cur!=null){
            if(pre.random == null)
                cur.random = null;
            else if(hmap.get(pre.random.label) != null)
                    cur.random = hmap.get(pre.random.label);
            else{
                cur.random = new RandomListNode(pre.random.label);
                hmap.put(pre.random.label, cur.random);
            }
            if(pre.next != null){
                if(hmap.get(pre.next.label) != null)
                    cur.next = hmap.get(pre.next.label);
                else{
                    cur.next = new RandomListNode(pre.next.label);
                    hmap.put(pre.next.label, cur.next);
                }
            }else
                cur.next = null;
            cur = cur.next;
            pre = pre.next;
        }
        return newHead;
    }
}
