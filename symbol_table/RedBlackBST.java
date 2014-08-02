import java.util.NoSuchElementException;

public class RedBlackBST<Key extends Comparable<Key>, Value>{
    
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;
    
    public void put(Key key, Value value){
        root = put (root, key, value);
        root.color = BLACK; //keeping the root black;
    }
    
    public Node put (Node h, Key key, Value value){
        if (h == null) return new Node (key, value, 1, RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key,value);
        else if (cmp > 0) h.right= put (h.right, key, value);
        else h.value = value;
        
        if (!isRed(h.left) && isRed(h.right)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        h.N = 1+size(h.left)+size(h.right);
        
        return h;
    }
    
    public Value get (Key key){
        Node x =  root;
        while (x != null){
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.value;
        }
        return null;
    }
    // delete the key-value pair with the minimum key
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;

        root = deleteMin(root);
        if (!isEmpty()) root.color = BLACK;
        // assert check();
    }

    // delete the key-value pair with the minimum key rooted at h
    private Node deleteMin(Node h) { 
        if (h.left == null)
            return null;

        if (!isRed(h.left) && !isRed(h.left.left))
            h = moveRedLeft(h);

        h.left = deleteMin(h.left);
        return balance(h);
    }
    private class Node{
        Key key;
        Value value;
        Node left, right;
        int N; //# of nodes in this subtree
        boolean color; //true is red, false is black
        
        Node (Key key, Value value, int N, boolean color){
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }
    private boolean isRed (Node x){
        if (x==null) return false;
        return x.color==RED;
    }
    
    private Node rotateLeft (Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.N = h.N;
        x.color = h.color;
        h.color = RED;
        h.N = 1+ size(h.left) + size(h.right);
        return x;
    }
    private Node rotateRight (Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.N = h.N;
        x.color = h.color;
        h.color = RED;
        h.N = 1+ size(h.left) + size(h.right);
        return x;
    }
    private void flipColors (Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    private Node moveRedLeft(Node h) {
        // assert (h != null);
        // assert isRed(h) && !isRed(h.left) && !isRed(h.left.left);

        flipColors(h);
        if (isRed(h.right.left)) { 
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }
        return h;
    }
    // restore red-black tree invariant
    private Node balance(Node h) {
        // assert (h != null);

        if (isRed(h.right))                      h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))     flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }
    private int size(Node h){
        if (h == null) return 0;
        else return h.N;
    }
    public boolean isEmpty() {
        return root == null;
    }
    
    /*****************************************************************************
    *  Test client
    *****************************************************************************/
    public static void main(String[] args) { 
        RedBlackBST<String, Integer> st = new RedBlackBST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        /*
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
        StdOut.println();
        */
    }
}