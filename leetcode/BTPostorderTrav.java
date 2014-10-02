
public class BTPostorderTrav {
	private List<Integer> result;
    public List<Integer> postorderTraversal(TreeNode root) {
        result = new ArrayList<Integer>();
        if(root == null) return result;
        visitRec(root);
        return result;
    }
    private void visitRec(TreeNode root){
        if(root == null)
            return;
        visitRec(root.left);
        visitRec(root.right);
        result.add(root.val);
    }
}
