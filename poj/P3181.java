import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class P3181{
    private static int N,K;
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        N = in.nextInt();
        K = in.nextInt();
        //注意数据，真的会越界
        BigInteger[] ctr = new BigInteger[N+1];
        for(int i = 0; i < N+1; i++)
            ctr[i] = BigInteger.ZERO;
        for(int i =1; i <= K; i++)
            for(int j = i; j <= N; j++)
                if(j == i)
                    ctr[j]=ctr[j].add(BigInteger.ONE);
                else
                    ctr[j]= ctr[j].add(ctr[j-i]) ;
        System.out.println(ctr[N]);
    }
}