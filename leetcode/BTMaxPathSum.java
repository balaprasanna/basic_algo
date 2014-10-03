//注意node的值可能是负数
public class BTMaxPathSum {
	private int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solveRec(root);
        if(sum == Integer.MIN_VALUE)
            return 0;
        return sum;
    }
    private int solveRec(TreeNode root){
        if(root == null)
            return 0;
        int l = solveRec(root.left);
        int r = solveRec(root.right);
        int re = Math.max(root.val, Math.max(l,r)+root.val);
        sum = Math.max(sum, re);
        sum = Math.max(sum, l+r+root.val);
        return re;
    }
}
