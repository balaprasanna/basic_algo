public SequentialSearchST<Key, Value>{
    private int N;
    private Node first;
    
    public SequentialSearchST{}
    
    public int size() {return N;}
    
    public boolean isEmpty() {return N == 0; }
    
    public boolean contains(Key key) { return get(key) != null ;}
     
    public Value get (Key key){
        if (isEmpty()) return null;
        for (Node current = first; current != null; current = current.next)
            if (key.equals(current.key)) return current.value;
        return null;
    }
    
    public void put (Key key, Value value){
        if (value == null) { delete(key); return; }
        for (Node x = first; x != null; x = x.next)
            if(key.equals(x.key)) {x.value = value; return;}
        Node last = new Node(key, value, null);
        x.next = last;
        N ++;
    }
    
    //no recursive implementation here
    public void delete(Key key){
        Node pre = null;
        for  (Node x = first; x!=null; x = x.next){
            if (key.equals(x.key)){
                if (pre == null) {first = x.next; return; }
                else {previous = x.next; return;}
            }
            pre = x;
        }
    }
    
    public Iterable<Key> keys(){
        Queue<Key> keys=  new Queue<Key>();
        for (Node x = first;  x!=null; x = x.next)
            keys.enqueue(x.key);
        return keys;
    }
        
    private class Node{
        private Key key;
        private Value value;
        private Node next;
        
        public Node (Key key, Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}