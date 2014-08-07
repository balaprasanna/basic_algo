/** 
 * Definition for binary tree 
 * public class TreeNode { 
 *     int val; 
 *     TreeNode left; 
 *     TreeNode right; 
 *     TreeNode(int x) { val = x; } 
 * } 
 */ 
public class SameTreeSolution { 
    public boolean isSameTree(TreeNode p, TreeNode q) { 
        if (p == null || q == null) { 
            if (p == null && q ==null) return true; 
            else return false; 
        } 
         
        if (p.val != q.val) return false; 
        if (!isSameTree(p.left, q.left)) return false; 
        if (!isSameTree(p.right, q.right)) return false; 
        return true; 
    } 
}