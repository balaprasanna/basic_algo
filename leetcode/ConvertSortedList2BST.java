//try to do without global variable next time
public class ConvertSortedList2BST {
	private ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        int n = 1;
        ListNode item = head;
        while(item.next != null){
            item = item.next;
            n++;
        }
        cur = head;
        return buildRec(head, n);
    }
    private TreeNode buildRec(ListNode head, int len){
        if(len == 0)
            return null;
        if(len == 1){
            TreeNode root = new TreeNode(cur.val);
            cur = cur.next;
            return root;
        }
        int mid = (len+1)/2;
        TreeNode leftChild = buildRec(head, mid-1);
        
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        root.left = leftChild;
        root.right = buildRec(cur, len-mid);
        
        return root;
    }
}
