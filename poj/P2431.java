import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class P2431 {
    public static void main(String[] args) throws IOException {
        P2431 m = new P2431();
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        Stop[] stops = new Stop[n];
        for(int i = 0; i < n; i++){
            //pay attention to this
            stops[i] =m.new Stop();
            stops[i].dist = in.nextInt();
            stops[i].fuel = in.nextInt();
        }
        Arrays.sort(stops);
        int l = in.nextInt();//length to town
        int p = in.nextInt();//fuel units left
        int ctr = n-1;
        int times = 0;
        //pay attention to change min to max heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(n, Collections.reverseOrder());
        l -= p;
        while(l>0){
            for(;ctr>=0 && stops[ctr].dist>=l ; ctr--){
                pq.add(stops[ctr].fuel);
            }
            if(!pq.isEmpty()){
                l -= pq.poll();
                times++;
            }else
                break;
            
        }
        if(l > 0)
            System.out.println(-1);
        else
            System.out.println(times);
    }
    class Stop implements Comparable<Stop>{
        int dist,fuel;
        public int compareTo(Stop o){
            return this.dist - o.dist;
        }
    } 
}
