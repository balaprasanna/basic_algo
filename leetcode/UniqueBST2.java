import java.util.ArrayList;
import java.util.List;


public class UniqueBST2 {
	public List<TreeNode> generateTrees(int n) {
        List<ArrayList<TreeNode>> store = new ArrayList<ArrayList<TreeNode>>();
        store.add(new ArrayList<TreeNode>());
        store.get(0).add(null);
        
        for(int len = 1; len <= n; len++)
        {
            store.add(new ArrayList<TreeNode>());
            if(len == 1)
                store.get(len).add(new TreeNode(1));
            else{
                for(int j = 1; j <= len; j++){
                    for(TreeNode l: store.get(j-1))
                        for(TreeNode r: store.get(len-j)){
                            TreeNode root = new TreeNode(j);
                            root.left = clone(l, 0);
                            root.right = clone(r, j);
                            store.get(len).add(root);
                        }
                }
            }
        }
        return store.get(n);
    }
    //make a copy with shift
    private TreeNode clone(TreeNode root, int shift){
        if(root == null) return root;
        //how to clone a tree
        //pre-order travesal
        TreeNode nroot = new TreeNode(root.val + shift);
        if(root.left != null){
            nroot.left = clone(root.left, shift);
        }
        if(root.right != null)
            nroot.right = clone(root.right, shift);
            
        return nroot;
    }
    private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; left = null; right = null; }
    }
}
