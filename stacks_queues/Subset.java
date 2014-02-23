public class Subset{
    public static void main(String[] args)
    {
        int K = Integer.parseInt(args[0]); //this is read in from args
        String[] inputs =  StdIn.readAllStrings(); // this is read in from stdin
        RandomizedQueue rq = new RandomizedQueue();
        
        for(String i: inputs)
            rq.enqueue(i);
//        if(rq.size()!=inputs.length)
//            StdOut.println("Not match!");
        for(int i = 0; i < K; i++)
        {
            StdOut.println(rq.dequeue());
           // StdOut.println(rq.size());
        }
        rq = null;
    }
}