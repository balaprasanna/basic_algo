//in-order: 先左子，然后root,最后右子
public class BinaryTreeInorderTraversal {
	private List<Integer> result;
    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<Integer>();
        inorderVisit(root);
        
        return result;
    }
    private void inorderVisit(TreeNode root){
        if(root == null) return;
        inorderVisit(root.left);
        result.add(root.val);
        inorderVisit(root.right);
    }
}
