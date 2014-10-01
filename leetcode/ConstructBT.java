//Construct Binary Tree from Preorder and Inorder Traversal
//construct a tree top-down
//recursive return left-child, right-child
public class ConstructBT {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildRec(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    private TreeNode buildRec(int[] preorder, int pi, int pj, int[] inorder, int ii, int ij ){
        if(pi > pj)
            return null;
        if(pi == pj)
            return new TreeNode(preorder[pi]);
            
        int curVal = preorder[pi];
        TreeNode root = new TreeNode(curVal);
        int x = 0;
        for(x = ii; x<=ij; x++)
            if(inorder[x]== curVal) break;
        root.left = buildRec(preorder, pi+1, x-ii+pi, inorder,ii, x-1);
        root.right = buildRec(preorder,pj-(ij-x)+1,pj, inorder, x+1, ij);
        return root;
    }
}
