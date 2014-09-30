
public class RecoverBST {
	private TreeNode p1, p2;
    private int v1, v2;
    public void recoverTree(TreeNode root) {
        v1 = Integer.MIN_VALUE;
        checkLeft(root);
        v2 = Integer.MAX_VALUE;
        checkRight(root);
        
        p1.val = v2;
        p2.val = v1;
    }
    private boolean checkLeft(TreeNode root){
        if(root == null) return true;
        if(!checkLeft(root.left)) return false;
        if(root.val > v1)
        {
            v1 = root.val;
            p1 = root;
        }else  return false;
        if(!checkLeft(root.right)) return false;
        return true;
    }
    private boolean checkRight(TreeNode root){
        if(root == null) return true;
        if(!checkRight(root.right)) return false;
        if(root.val < v2){
            v2 = root.val;
            p2 = root;
        }else return false;
        if(!checkRight(root.left)) return false;
        return true;
    }
}
