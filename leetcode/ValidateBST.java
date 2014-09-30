//自己解决的，但还是值得复习一下
//注意in-order和全局变量的应用
public class ValidateBST {
	private int pre =Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(!isValidBST(root.left))
            return false;
        if(root.val > pre)
            pre = root.val;
        else return false;
        if(!isValidBST(root.right))
            return false;
        return true;
    }
}
