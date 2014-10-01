//除了level order trav的办法
public class MinDepthOfBT {
	public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return height(root);
    }
    private int height(TreeNode root){
        if(root.left == null && root.right == null)
            return 1;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(root.left != null)
            left = height(root.left);
        if(root.right!=null)
            right = height(root.right);
        return Math.min(left, right)+1;
    }
}
