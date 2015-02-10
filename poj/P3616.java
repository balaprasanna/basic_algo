import java.io.*;
import java.util.*;

class Interval implements Comparable<Interval>{
    int start,end,ef;
    public Interval(int s, int e, int ef){
        this.start = s;
        this.end = e;
        this.ef = ef;
    }
    public int compareTo(Interval o){
        return this.end - o.end;
    }
}
public class P3616{
    private static int N,M,R;
    private static int[] milk;
    private static Interval[] itvs;
    
    private static int solve(int t){
        if(milk[t] != -1)
            return milk[t];
        if(t == 0)
            return milk[0] = itvs[0].ef;
        int tmp = 0;
        for(int i = 0; i < t; i++){
            if(itvs[t].start-R >= itvs[i].end)
                tmp = Math.max(tmp, solve(i)+ itvs[t].ef);
            else
                tmp = Math.max(tmp, solve(i));
        }
        tmp = Math.max(tmp, itvs[t].ef);
        return milk[t] = tmp;
            
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        N = in.nextInt();//time
        M = in.nextInt();//interval
        R = in.nextInt();//rest time
        milk = new int[M];
        for(int i = 0; i < M; i++)
            milk[i] = -1;
        itvs = new Interval[M];
        for(int i = 0; i < M; i++)
            itvs[i] = new Interval(in.nextInt(), in.nextInt(), in.nextInt());
        Arrays.sort(itvs);
        solve(M-1);
        System.out.println(milk[M-1]);
            
    }
}