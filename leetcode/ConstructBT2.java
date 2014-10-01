//Same as constructBT
public class ConstructBT2 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildRec(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    private TreeNode buildRec(int[] inorder, int ii, int ij, int[] postorder, int pi, int pj){
        if(pi > pj)
            return null;
        if(pi == pj)
            return new TreeNode(postorder[pi]);
        int curVal = postorder[pj];
        TreeNode root = new TreeNode(curVal);
        int x = 0;
        for(x = ii; x <= ij; x++)
            if(inorder[x] == curVal) break;
        root.left = buildRec(inorder, ii, x-1, postorder, pi, pi+x-ii-1);
        root.right = buildRec(inorder, x+1, ij, postorder, pj-(ij-x),pj-1);
        return root;
    }
}
