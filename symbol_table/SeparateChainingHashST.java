public SeparateChainingHashST<Key, Value>{
    private final int INIT_CAPACITY = 4; //why 4?
    private int M;
    private int N;
    private SequentialSearchST<Key, Value>[] st;
    public SeparateChainingHashST(){
        this(INIT_CAPACITY);
    }
    public SeparateChainingHashST(int M){
        this.M = M;
        st = new SequentialSearchST<Key, Value>(M);
        for (int i = 0; i < M; i ++)
            st[i] = new SequentialSearchST<Key, Value>();
    }
    public int hash(Key key){
        return (key.hashCode() & 0x7FFFFFFF) % M;
    }
    public void put (Key key, Value value){
        if (value == null) {delete(key); return;}
        int h = hash(key);
        int oldsize = st[h].size();
        st[h].put(key, value);
        N = N - oldsize + st[h].size();
        if (N >10* M ) resize(2*M);
    }
    public Value get (Key key) {
        int h = hash(key);
        return st[h].get(key);
    }
    public void delete(Key key){
        int h = hash(key);
        int oldsize = st[h].size();
        st[h].delete(key);
        N = N - oldsize + st[h].size();
        if (M > INIT_CAPACITY && N<2*M) resize(M/2);
    }
    public boolean contains(Key key){ return get(key)!= null;}
    public void resize(int M){
        //TODO
    }
    public int size() {return N;}
    public boolean isEmpty() {return N == 0;}
    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    }
}