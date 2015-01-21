import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class P3253 {
    private static int n;
    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(System.in);
        n = in.nextInt();
        BigInteger sum = BigInteger.ZERO;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); //for heap
        for(int i = 0; i < n; i++)
            pq.add(in.nextInt());
        while(pq.size()>1){
            int min1 = pq.poll();
            int min2 = pq.poll();
            sum = sum.add(BigInteger.valueOf( min1 + min2));
            pq.add(min1+min2);
        }
        System.out.println(sum);
    }
}
