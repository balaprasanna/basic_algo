import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class P1384 {
    private static int v;
    private static int n; //various coins
    private static int[] p, w; //w for weight, p for value
    
    private static int solve(){
        int[] r = new int[v+1];
        for(int i = 1; i < v+1; i++)
            r[i] = Integer.MAX_VALUE/10;
        for(int i = 0; i < n; i++)
            for(int j = w[i]; j <=v; j++)
                    r[j] = Math.min(r[j], r[j-w[i]]+p[i]);
        return r[v];
    }
    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0){
            v = -in.nextInt()+in.nextInt();
            n = in.nextInt();
            p = new int[n];
            w = new int[n];
            for(int i = 0; i < n; i++){
                p[i] = in.nextInt();
                w[i] = in.nextInt();
            }
            int res = solve();
            if(res == Integer.MAX_VALUE/10)
                System.out.println("This is impossible.");
            else
                System.out.println("The minimum amount of money in the piggy-bank is "+res+".");
        }
    }
}
