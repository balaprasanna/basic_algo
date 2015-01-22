import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class P1442 {
    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[] numbers = new int[m];
        int[] gets = new int[n];
        for(int i = 0; i < m; i++)
            numbers[i] = in.nextInt();
        for(int i = 0; i < n; i++)
            gets[i] = in.nextInt();
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(m, Collections.reverseOrder());
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
        int k = 0;
        int j = 0;
        while(k < n){
            for(;j+1<=gets[k]; j++){
                if(k == 0 || numbers[j]>maxheap.peek())
                    minheap.add(numbers[j]);
                else{
                    minheap.add(maxheap.poll());
                    maxheap.add(numbers[j]);
                }
            }
            //pay attention to peek and poll
            maxheap.add(minheap.peek());
            System.out.println(minheap.poll());
            k++;
        }
    }
}
