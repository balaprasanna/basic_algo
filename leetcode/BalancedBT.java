
public class BalancedBT {
	public boolean isBalanced(TreeNode root) {
		return checkRec(root) .first();
    }
    private Pair<Boolean, Integer> checkRec(TreeNode root){
    	if(root == null)
    		return new Pair<Boolean, Integer>(true, 0);
    	Pair<Boolean, Integer> left = checkRec(root.left);
    	if( !left.first())
    		return new Pair<Boolean, Integer>(false, 0);
    	Pair<Boolean, Integer> right = checkRec(root.right);
    	if(!right.first())
    		return new Pair<Boolean, Integer>(false, 0);
    	if(Math.abs(left.height() - right.height()) >1)
    		return new Pair<Boolean, Integer>(false, 0);
    	return new Pair<Boolean, Integer>(true, Math.max(left.height(), right.height())+1);
    }
    private class Pair<Boolean, Integer>{
    	private Boolean first;
    	private Integer height;
    	public Pair(Boolean first, Integer height){
    		this.first = first;
    		this.height = height;
    	}
    	public Boolean first(){
    		return first;
    	}
    	public Integer height(){
    		return height;
    	}
    }
    private class TreeNode {
    	int val;
    	TreeNode left;
    	 TreeNode right;
    	 TreeNode(int x) { val = x; }
     }
}
