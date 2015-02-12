import java.io.*;
import java.util.*;

class WS implements Comparable<WS>{
    int l,w;
    public WS(int l, int w){
        this.l = l;
        this.w = w;
    }
    public int compareTo(WS o){
        if(this.l == o.l)
            return this.w-o.w;
        else
            return this.l-o.l;
    }
}
public class P1065{
    private static int N,K;
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int T = in.nextInt();
        while(T-->0){
            int n = in.nextInt(); //number of wooden sticks
            WS[] sticks = new WS[n];
            for(int i =0; i < n; i++)
                sticks[i] = new WS(in.nextInt(), in.nextInt());
            Arrays.sort(sticks);
            
            //sort之后寻找最长不可比较子序列,也就是偏序集的反链的长度
            //不可比较的元素肯定不会在同一上升链中
            WS[] non = new WS[n+1];
            non[1] = sticks[0];
            int len = 1;
            for(int i = 1; i < n; i++){
                WS cur = sticks[i];
                for(int j = 1; j <= len; j++){
                    if((cur.l - non[j].l)*(cur.w-non[j].w)>=0){
                        //dont forget to update this
                        non[j] = cur;
                        break;
                    }
                    if(j == len)
                        non[++len] = cur;
                }
            }
            //也可以用greedy方法直接求上升链的个数，明天做一下
            System.out.println(len);
        }
    }
}