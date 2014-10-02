
public class SumRoot2LeftNumbers {
	private int sum = 0;
    public int sumNumbers(TreeNode root) {
        sumRec(root, 0);
        return sum;
    }
    private void sumRec(TreeNode root, int pre){
        if(root == null) return;
        if(root.left == null && root.right == null){
            sum += pre*10 + root.val;
            return;
        }
        sumRec(root.left, pre*10+root.val);
        sumRec(root.right, pre*10+root.val);
    }
}
