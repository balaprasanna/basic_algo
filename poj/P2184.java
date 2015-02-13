import java.io.*;
import java.util.*;
//这是一个0/1背包问题的变种
public class P2184{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int N = in.nextInt(); //number of cows
        int[] smart = new int[N];
        int[] fun = new int[N];
        int s,f,l=0;
        for(int i = 0; i < N; i++){
            s = in.nextInt();
            f = in.nextInt();
            if(s < 0 && f < 0)
                continue; //this cow will not be used
            smart[l] = s;
            fun[l] = f;
            l++;
        }
        int S = 2000*l;
        //因为有负值，数组的index不可能为负，所以平移原点到Ori
        int Ori = 1000*l;
        int[] sum = new int[S+1];
        for(int i = 0; i <= S; i++)
            sum[i] = Integer.MIN_VALUE/10;
        sum[Ori] = 0;
        for(int i = 0; i < l; i++)
            if(smart[i] >=0)
                for(int j = S; j-smart[i]>=0; j--)
                    sum[j] = Math.max(sum[j], sum[j-smart[i]]+smart[i]+fun[i]);
            else
                for(int j=0; j-smart[i]<=S; j++)
                    sum[j] = Math.max(sum[j], sum[j-smart[i]]+smart[i]+fun[i]);
        int ret = 0;
        for(int i = Ori; i <= S; i++)
            if(sum[i] >= 0 && sum[i]>i-Ori)
                ret = Math.max(ret, sum[i]);
        System.out.println(ret);
    }
}