import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class MergeKSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.size() == 0) return null;
        //remove all null listnode from collection
        //http://www.mhaller.de/archives/12-How-to-remove-all-null-elements-from-a-Collection.html
        lists.removeAll(Collections.singleton(null));
        if (lists.size() == 0) return null;
        if (lists.size() == 1) return lists.get(0);
        //create a pq used as a heap, each element is a ListNode
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2){
                if (l1.val < l2.val) return -1;
                else if (l1.val == l2.val) return 0;
                else return 1;
            }
        });
        for(ListNode item: lists)
            pq.add(item);
        ListNode cur = pq.poll();
        ListNode r = cur;
        if (cur.next != null){
            pq.add(cur.next);
            cur.next = null;
        }
        while((cur.next = pq.poll())!=null){
        	cur = cur.next;
        	if (cur.next != null) pq.add(cur.next);
        	cur.next = null;
        }
        return r;
    }
}
