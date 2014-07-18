public class MaxPQ<Key extends Comparable<Key>>{
    //init: create an empty pq
    public MaxPQ(){}
    //init: change the input array into pq
    public MaxPQ(Key[] a){}
    
    public static void insert(Key v){}
    public static void delMax(){}
    public static boolean isEmpty(){}
    public static int size(){}
    
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