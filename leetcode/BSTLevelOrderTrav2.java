
public class BSTLevelOrderTrav2 {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
    Queue<TreeNode> qt = new LinkedList<TreeNode>();
    int ctr1 = 0, ctr2=1;
    if(root == null) return result;
    qt.add(root);
    while(qt.size() > 0){
        ctr1 = ctr2; ctr2 = 0;
        TreeNode cur = null;
        List<Integer> level = new ArrayList<Integer>();
        for(;ctr1 > 0; ctr1 --){
            cur = qt.poll();
            level.add(cur.val);
            if(cur.left!= null){
                qt.add(cur.left);
                ctr2++;
            }
            if(cur.right!=null){
                qt.add(cur.right);
                ctr2++;
            }
        }
        //The only modification compared to 1
        //this is insane
        result.add(0,level);
    }
    return result;
}
