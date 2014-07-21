public class MaxPQ<Key extends Comparable<Key>>{
    private Key[] pq;
    private int N = 0; //size of current heap
    //init: create an empty pq
    public MaxPQ(){}
    //init: change the input array into pq
    public MaxPQ(int MaxN){
        pq = (Key[]) new Comparable[MaxN+1];
    }
    public static void insert(Key v){
        pq[++N] = v;
        swim(v);
    }
    public static Key delMax(){
        Key max = pq[1];
        exch(1, N);
        pq[N--] = null;
        sink(1);
        return max;
    }
    public static boolean isEmpty(){return N == 0;}
    public static int size(){return N;}
    
    //auxiliary functions
    public static boolean less(int p, int q)
    {
        if (pq[p].compareTo(pq[q])<0) return true;
        else return false;
    }
    public static void swim(int k)
    {
        while(k > 1 && less(k/2, k)){
            exch(k, k/2);
            k = k/2;
        }
    }
    public static void sink(int k)
    {
        while(2*k<=N){
            int j = 2*k;
            if (j<N && less(j, j+1)) j++;
            if (!less(k,j)) break;
            exch(k, j);
            k = j;
        }
    }
    public static void exch(int p, int q)
    {
        Key temp = pq[p];
        pq[p] = pq[q];
        pq[q] = temp;
    }
    
    public static void main(String[] args){
        //find the M smallest items in streams of N items(both M and N large)
        M = 5; //or something read in from command line
        MaxPQ pq = new MaxPQ();
        while(StdIn.hasNextLine()){
            Key item = new Key(StdIn.readLine());
            pq.insert(item);
            if (pq.size>M) pq.delMax();
        }
    }
}