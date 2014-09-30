import java.util.LinkedList;
import java.util.Queue;


public class SymmetricTree {
	//recursive way
	public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return solveRec(root.left, root.right);
    }
    private boolean solveRec(TreeNode a, TreeNode b){
        if(a != null){
            if(b == null || a.val != b.val) return false;
            if(solveRec(a.left, b.right) && solveRec(a.right, b.left))
                return true;
            else return false;
        }
        return b == null;
    }
    //iterative way
    public static boolean isSymmetric2(TreeNode root) {
    	if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root.left);
        q.add(root.right);
        TreeNode l = null, r = null;
        while(q.size() > 0){
            l = q.poll();
            r = q.poll();
            if(l != null && r != null){
                if(l.val != r.val) return false;
                q.add(l.left); q.add(r.right);
                q.add(l.right); q.add(r.left);
                
            }else if(l!= null || r!= null)
                return false;
        }
        if(l == null && r == null) return true;
        return false;
    }
    private class TreeNode{
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x){val = x;}
    }
    public static void main(String[] args){
    	SymmetricTree test = new SymmetricTree();
    	TreeNode node = test.new TreeNode(1);
    	node.left = test.new TreeNode(2);
    	node.right = test.new TreeNode(2);
    	TreeNode f = node.left;
    	f.right = test.new TreeNode(3);
    	TreeNode r = node.right;
    	r.right = test.new TreeNode(3);
    	isSymmetric2(node);
    }
}
