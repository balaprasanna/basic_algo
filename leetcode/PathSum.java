
public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return checkRec(root, sum);
    }
    private boolean checkRec(TreeNode root, int sum){
        if(isLeaf(root))
            return root.val == sum;
        //if(root.val > sum)
        //    return false;
        //if(root.val == sum && !isLeaf(root))
        //   return false;
        if(root.left != null && checkRec(root.left, sum - root.val))
            return true;
        if(root.right != null && checkRec(root.right, sum-root.val))
            return true;
        return false;
    }
    private boolean isLeaf(TreeNode root){
        if(root.left == null && root.right == null)
            return true;
        return false;
    }
}
