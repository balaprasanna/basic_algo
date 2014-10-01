
public class PathSum2 {
	private List<List<Integer>> result;
    private List<Integer> item;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        item = new ArrayList<Integer>();
        checkRec(root, sum);
        return result;
    }
    private boolean checkRec(TreeNode root, int sum ){
        if(isLeaf(root)){
            if(root.val == sum){
                item.add(root.val);
                result.add(new ArrayList<Integer>(item));
                item.remove(item.size()-1);
                return true;
            }else
                return false;
        }
        item.add(root.val);
        boolean flag = false;
        if(root.left!=null && checkRec(root.left, sum-root.val))
            flag = true;
        if(root.right!=null && checkRec(root.right, sum-root.val))
            flag = true;
        item.remove(item.size()-1);
        return flag;
    }
    private boolean isLeaf(TreeNode root){
        if(root.left == null && root.right == null)
            return true;
        return false;
    }
}
