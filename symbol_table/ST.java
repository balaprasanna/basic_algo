public class ST<Key extends ,Value>{
    public void put(Key key, Value value){}
    public Key get(Key key){}
    public void delete(Key key){}
    public boolean contains(Key key){return get(key)!= null;}
    public boolean isEmpty(){}{return size()==0;}
    public int size(){}
    //test client: traces, frequency counter
    public static void main(String[] args){
        ST<String, Integer> st = new ST<String, Integer>();
        for (int i=0; !StdIn.isEmpty(); i++)
        {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String key: st.keys())
            StdOut.println(key+" "+st.get(key));
    }
}