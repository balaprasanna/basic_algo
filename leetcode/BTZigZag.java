
public class BTZigZag {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        
        List<TreeNode> preLevel = new ArrayList<TreeNode>();
        preLevel.add(root);
        boolean flag = true;
        while(preLevel.size()>0){
            List<Integer> curLevel = new ArrayList<Integer>();
            List<TreeNode> cur = new ArrayList<TreeNode>();
            for(TreeNode tree: preLevel){
                if(tree.left != null)
                    cur.add(tree.left);
                if(tree.right != null)
                    cur.add(tree.right);
                if(flag)
                    curLevel.add(tree.val);
                else
                    curLevel.add(0, tree.val);
            }
            result.add(curLevel);
            preLevel = cur;
            flag = !flag;
        }
        return result;
    }
}
