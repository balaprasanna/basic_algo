import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item>
{
    private Item[] a;
    private int first, last;
    private int N;
    
    //construct an empty randomized queue
    public RandomizedQueue()
    {
        a = (Item[]) new Object[2]; 
        first = 0;
        last = 0;
        N = 0;
    }
    
    //is the queue empty?
    public boolean isEmpty() { return N == 0; }
    
    // return the number of items on the queue
    public int size() { return N; }
    
     // resize
    private void resize(int capacity)
    {
        assert capacity >= N;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++)
            temp[i] = a[(first+i)% a.length];
        a = temp;
        first = 0;
        last = N;
    }
    
    // add the item
    public void enqueue(Item item)
    {
        checkItem(item);
        if (size() == a.length) resize(2*a.length);
        a[last++] = item;
        if (last == a.length) last = 0;
        N++;
    }
    //exchange
    private void exch(Item[] a, int m, int n)
    {
        Item temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }
    // delete and return a random item
    public Item dequeue()
    {
        checkDequeue();
        int r = (StdRandom.uniform(N)+first)%a.length;
        exch(a,first,r);
        Item item = a[first];
        a[first] = null;
        N--;
        first++;
        if (first == a.length) first = 0; //warp-around
        //shrink size of array if necessary
        if (N > 0 && N == a.length/4) resize(a.length/2);
        return item;
    }
    
    // return (but do not delete) a random item
    public Item sample()
    {
        checkDequeue();
        int r = (StdRandom.uniform(N)+first)%a.length;
        return a[r];
    }
    
    // return an independent iterator over items in random order
    public Iterator<Item> iterator() 
    { 
        Item[] random = (Item[]) new Object[size()];
        for (int k = 0; k< size(); k++)
                random[k] = a[(k+first)%a.length];
            StdRandom.shuffle(random);
        return new ArrayIterator(random); 
    }
    
    private class ArrayIterator implements Iterator<Item>
    {
        private int i = 0;
        private Item[] random;
        public ArrayIterator(Item[] random) { this.random = random;}
        public void remove() { throw new UnsupportedOperationException(); }
        public boolean hasNext() { return i < N; }
        public Item next()
        {
            if (!hasNext()) 
                throw new NoSuchElementException("No more element!");
            Item item = random[(i+first)%random.length];
            i++;
            return item;
        }
    }
    // input checking
    private void checkItem(Item item)
    { 
        if (item == null) 
            throw new NullPointerException("Null item can not be added.");
    }
    // dequeue checking
    private void checkDequeue()
    { 
        if (isEmpty()) 
            throw new NoSuchElementException("No more element to remove!");
    }
   
    // shift to left several steps
//    private void shift(int startpoint, int step)
//    {
//        for (int i = startpoint; i <= tail; i++)
//            a[i-step] = a[i];
//        if (startpoint == head) head = head- step;
//        tail = tail - step;
//    }
    //unit testing
    public static void main(String[] args) {
        String[] inputs =  StdIn.readAllStrings(); // this is read in from stdin
        RandomizedQueue rq = new RandomizedQueue();
        
        for (String i: inputs)
            rq.enqueue(i);
        StdOut.println(rq.size());
        for (Object k: rq)
            StdOut.println(k);
        StdOut.println();
        for (Object p: rq)
            StdOut.println(p);
    }
    
    
}