
public class CovertSortedArray2BST {
	public TreeNode sortedArrayToBST(int[] num) {
        return buildRec(num, 0, num.length-1);
    }
    private TreeNode buildRec(int[] num, int i, int j){
        if(i>j) return null;
        if(i == j) return new TreeNode(num[i]);
        int mid = (i+j)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = buildRec(num, i, mid-1);
        root.right = buildRec(num, mid+1, j);
        return root;
    }
}
