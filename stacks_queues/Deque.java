import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node first = null;
    private Node last = null;
    private int N = 0;
    private class Node
    {
        private Item item;
        private Node next;
        private Node previous;
    }
    
    // construct an empty deque
    public Deque() { }
    // is the deque empty?
    public boolean isEmpty()
    { return N == 0; }
    // return the number of items on the deque
    public int size()
    { return N; }
    // insert the item at the front
    public void addFirst(Item item)
    {
        checkItem(item);
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        if (isEmpty())
            last = first;
        else 
        {
            first.next = oldfirst;
            oldfirst.previous = first;
        }
        N++;
    }
    // insert the item at the end
    public void addLast(Item item)
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
    // delete and return the item at the front
    public Item removeFirst()
    {
        checkDeque();
        Item item = first.item;
        if (size() == 1) 
        { 
            first = null; 
            last = null; 
        }
        else 
        { 
            first = first.next; 
            first.previous = null; 
        } 
        N--;
        return item;
    }
    // delete and return the item at the end
    public Item removeLast()
    {
        checkDeque();
        Item item = last.item;
        if (size() == 1) 
        { 
            first = null; 
            last = null; 
        }
        else 
        { 
            last = last.previous; 
            last.next = null; 
        }
        N--;
        return item;
    }
    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() { return new ListIterator(); }
    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext() { return current != null; }
        public void remove() { throw new UnsupportedOperationException(); }
        public Item next()
        {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    
    private void checkItem(Item item)
    { 
        if (item == null) 
            throw new NullPointerException("Null item can not be added.");
    }
    private void checkDeque()
    { 
        if (isEmpty()) 
            throw new java.util.NoSuchElementException("Deque already empty.");
    }
    // unit testing
    public static void main(String[] args)
    {
        Deque test1 = new Deque();
        for (int i = 0; i < 20; i++)
        {
            test1.addFirst(i);
        }

    }
   
       
       
   
}