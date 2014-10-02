//original problem -123 should also be done in this way
public class PopulatingNextRightPointerBT2 {
	//I'll solve this prob in a iterative way
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode preHead = root;
        TreeLinkNode cur = preHead;
        TreeLinkNode pre = null;
        while(preHead != null){
            pre = null;
            cur = preHead;
            preHead = null;
            while(cur!=null){
                if(!isLeaf(cur)){
                    if(cur.left != null){
                        if(preHead == null){
                            preHead = cur.left;
                            pre = preHead;
                        }
                        else{
                            pre.next = cur.left;
                            pre = pre.next;
                        }
                    }
                    if(cur.right != null){
                        if(preHead == null){
                            preHead = cur.right;
                            pre = cur.right;
                        }
                        else{
                            pre.next = cur.right;
                            pre = pre.next;
                        }
                    }
                }
                cur = cur.next;
            }
        }
    }
    private boolean isLeaf(TreeLinkNode root){
        if(root.left == null && root.right == null)
            return true;
        return false;
    }
}
