import java.io.*;
import java.util.*;

class Block implements Comparable<Block>{
    int h,c,a;
    public Block(int h, int a, int c){
        this.h = h;
        this.c = c;
        this.a = a;
    }
    public int compareTo(Block o){
        return this.a-o.a;
    }
}
public class P2392{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int K = in.nextInt();
        Block[] bs = new Block[K];
        int maxh = 0;
        for(int i = 0; i < K; i++){
            bs[i] = new Block(in.nextInt(), in.nextInt(), in.nextInt());
            maxh = Math.max(maxh, bs[i].a);
        }
        Arrays.sort(bs);
        boolean[] reach = new boolean[maxh+1];
        reach[0] = true;
        for(int i = 0; i < K; i++){
            int h = bs[i].h;
            for(int j = 1; j <= Math.min(bs[i].c,maxh/h); j++)
                for(int k = bs[i].a; k >=h; k--)
                    //pay attention to this
                    //without if, true maybe turned into false by mistake
                    if(!reach[k])
                        reach[k] = reach[k-h];
        }
        int ret = maxh;
        while(!reach[ret])
            ret--;
        System.out.println(ret);
        
    }
}