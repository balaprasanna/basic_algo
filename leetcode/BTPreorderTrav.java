
public class BTPreorderTrav {
	private List<Integer> result;
    public List<Integer> preorderTraversal(TreeNode root) {
        result = new ArrayList<Integer>();
        if(root == null) return result;
        visitRec(root);
        return result;
    }
    private void visitRec(TreeNode root){
        if(root == null)
            return;
        result.add(root.val);
        visitRec(root.left);
        visitRec(root.right);
    }
}
