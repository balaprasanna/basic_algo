
public class PopulatingNextRightPointerBT {
	public void connect(TreeLinkNode root) {
        if(root == null) return;
        linkRec(root);
    }
    private void linkRec(TreeLinkNode root){
        if(isLeaf(root)) return;
        //perfect BT
        linkRec(root.left);
        linkRec(root.right);
        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;
        left.next = right;
        while(left.right != null){
            left = left.right;
            right = right.left;
            left.next = right;
        }
    }
    private boolean isLeaf(TreeLinkNode root){
        if(root.left == null && root.right == null)
            return true;
        return false;
    }
}
