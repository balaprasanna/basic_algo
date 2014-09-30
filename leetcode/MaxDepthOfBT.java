
public class MaxDepthOfBT {
	private int dep = 0;
    private int height = 0;
    public int maxDepth(TreeNode root) {
        trav(root);
        return dep;
    }
    private void trav(TreeNode root){
        if(root == null) return;
        height++;
        dep = Math.max(height, dep);
        trav(root.left);
        trav(root.right);
        height--;
        return;
    }
}
