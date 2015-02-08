import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

class Cow implements Comparable<Cow>{
    int t,d;
    public Cow(int t, int d){
        this.t = t;
        this.d = d;
    }
    public int compareTo(Cow o){
        return t*o.d - d*o.t;
    }
}
public class P3262 {   
    public static void main(String[] args) {   
        Scanner in = new Scanner(System.in);   
        int N = in.nextInt();
        Cow[] cows = new Cow[N];
        int dsum = 0;
        for(int i = 0; i < N; i++){
            cows[i] = new Cow(in.nextInt(), in.nextInt());
            dsum += cows[i].d;
        }
            
        Arrays.sort(cows);
        long ret = 0;
        for(int i = 0; i < N; i++){
            dsum -= cows[i].d;
            ret += 2*cows[i].t*dsum;
        }
            
        System.out.println(ret);
    }   
  
}
