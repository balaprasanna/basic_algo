import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue3{
    private Node first = null;
    private Node last = null;
    private int N = 0;
    
    private class Node
    {
        private Item item;
        private Node next;
        private Node previous;
    }
    // construct an empty RQ
    public RandomizedQueue3() { }
    // is the deque empty?
    public boolean isEmpty()
    { return N == 0; }
    // return the number of items on the deque
    public int size()
    { return N; }
    // add the item
    public void enqueue(Item item)
    {
        checkItem(item);
        Node oldlast = last;
        last = new Node();
        last.item = item;
        if (isEmpty())
            first = last;
        else
        {
            oldlast.next = last;
            last.previous = oldlast;
        }
        N++;
    }
     // delete and return a random item
    public Item dequeue()
    {
        checkDequeue();
        Item item;
        if (size() == 1)
        {
            item = first.item;
            first = null;
            last = null;
            N = 0;
            return item;
        }
        else
        {
            int r = StdRandom.uniform(N)+1;
            item = a[r];
            if (r = )
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
    
}