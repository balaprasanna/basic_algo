import java.util.HashMap;
//doubly-linked list

public class LRUCache {
	Node head;
    Node tail;
    int capacity;
    int count;
    HashMap<Integer, Node> hmap = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(hmap.containsKey(key)){
            Node cur = hmap.get(key);
            remove(cur);
            insert(cur);
            return cur.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(hmap.containsKey(key)){
        	Node cur = hmap.get(key);
        	cur.val= value;
        	remove(cur);
        	insert(cur);
        }
            
        else{
            if(count == capacity){
                hmap.remove(head.next.key);
                remove(head.next);
            }
            else
                count++;
            Node cur = new Node(key, value);
            hmap.put(key, cur);
            insert(cur);
        }
    }
    private void remove(Node cur){
        Node pre = cur.pre;
        Node next = cur.next;
        pre.next = next;
        next.pre = pre;
        cur = null;
    }
    private void insert(Node cur){
        Node pre = tail.pre;
        pre.next = cur;
        cur.next = tail;
        tail.pre = cur;
        cur.pre = pre;
    }
    class Node{
        int key;
        int val;
        Node pre;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    public static void main(String[] args){
    	LRUCache c = new LRUCache(1);
    	c.set(2,1);
    	c.get(2);
    	c.set(3,2);
    	c.get(2);
    	c.get(3);
    }
}
