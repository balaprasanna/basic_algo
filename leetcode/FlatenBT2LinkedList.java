
public class FlatenBT2LinkedList {
	public void flatten(TreeNode root) {
        if(root == null) return;
        flatRec(root);
    }
    private Pair<TreeNode> flatRec(TreeNode root){
        if(root.left == null && root.right == null)
            return new Pair<TreeNode>(root, root);
        TreeNode head = root, tail = root;
        TreeNode rightChild = root.right;
        if(root.left != null){
            Pair<TreeNode> l = flatRec(root.left);
            tail.right = l.getHead();
            tail.left = null;
            tail = l.getTail();
        }
        if(rightChild != null){
            Pair<TreeNode> r = flatRec(rightChild);
            tail.right = r.getHead();
            tail.left = null;
            tail = r.getTail();
        }
        return new Pair<TreeNode>(head, tail);
    }
    private class Pair<TreeNode>{
        private TreeNode head;
        private TreeNode tail;
        //not Pair<TreeNode> here
        public Pair(TreeNode head, TreeNode tail){
            this.head = head;
            this.tail = tail;
        }
        public TreeNode getHead(){return head;}
        public TreeNode getTail(){return tail;}
    }
    public class TreeNode {
    	      int val;
    	      TreeNode left;
    	      TreeNode right;
    	      TreeNode(int x) { val = x; }
     }
}
