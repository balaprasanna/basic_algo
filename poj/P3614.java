import java.io.*;
import java.util.*;


class cow implements Comparable<cow>{
    int min, max;
    public cow (int min, int max){
        this.min = min;
        this.max = max;
    }
    public int compareTo(cow o){
        if(this.min == o.min)
            return this.max-o.max;
        else
            return this.min-o.min;
    }
}
class Bottle implements Comparable<Bottle>{
    int SPF, size;
    public Bottle(int SPF, int size){
        this.SPF = SPF;
        this.size = size;
    }
    public int compareTo(Bottle o) {
        return this.SPF-o.SPF;
    }
}
public class P3614{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int C = in.nextInt();
        int L = in.nextInt();
        cow[] cows = new cow[C];
        for(int i = 0; i < C; i++)
            cows[i] = new cow(in.nextInt(),in.nextInt());
        Bottle[] bs = new Bottle[L];
        for(int i =0; i < L; i++)
            bs[i] = new Bottle(in.nextInt(), in.nextInt());
        Arrays.sort(cows);
        Arrays.sort(bs);
        int cur = 0;
        int ret = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i < L; i++){
            while(cur < C && cows[cur].min <= bs[i].SPF){
                pq.add(cows[cur].max);
                cur++;
            }
            while(!pq.isEmpty() && bs[i].size > 0){
                if(pq.poll()>=bs[i].SPF){
                    ret++;
                    bs[i].size--;
                }
            }
        }
        System.out.println(ret);
    }
}