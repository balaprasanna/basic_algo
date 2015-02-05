import java.io.*;
import java.util.*;

class Range implements Comparable<Range>{
    int x,y, stall;
    public Range(int x, int y){
        this.x = x;
        this.y = y;
        this.stall = 0;
    }
    public int compareTo(Range o) {
        if(this.x < o.x)
            return -1;
        else if(this.x > o.x)
            return 1;
        else
            return -this.y + o.y;
    }
}
class Stall implements Comparable<Stall>{
    int time, number;
    public Stall(int t, int n){
        this.time = t;
        this.number = n;
    }
    public int compareTo(Stall o){
        return this.time-o.time;
    }
}
public class P3190 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Range[] slots = new Range[n];
        Range[] origins = new Range[n];
        //int[] stalls = new int[n];
        //PriorityQueue<Range> pq = new PriorityQueue<Range>(n);
        PriorityQueue<Stall> stalls = new PriorityQueue<Stall>();
        for(int i = 0; i < n; i++){
            slots[i] = new Range(in.nextInt(), in.nextInt());
            origins[i] = slots[i];
        }    
        Arrays.sort(slots);
        Range next;
        for(int k = 0; k < n; k++){
            next = slots[k];
            if(stalls.size() == 0){
                stalls.add(new Stall(next.y, 1));
                next.stall = 1;
                continue;
            }
            if(stalls.peek().time < next.x){
                Stall tmp = stalls.poll();
                next.stall = tmp.number;
                tmp.time = next.y;
                stalls.add(tmp);
            }else{
                int s = stalls.size();
                stalls.add(new Stall(next.y, s+1));
                next.stall = s+1;
            }
        }
        System.out.println(stalls.size());
        for(int i = 0; i < n; i++)
            System.out.println(origins[i].stall);
    }
}
