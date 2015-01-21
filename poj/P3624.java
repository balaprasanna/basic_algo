import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class P3624 {
    private static int N,M;// M is limit
    private static int[] w, d; //w for weight, d for value
    
    private static int solve(){
        int[] res = new int[M+1];
        for(int i = 0; i < N; i++)
            for(int j = M; j >=w[i]; j--)
                res[j] = Math.max(res[j], res[j-w[i]]+d[i]);
        return res[M];
    }
    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        w = new int[N];
        d = new int[N];
        for(int i =0; i<N; i++){
            w[i] = in.nextInt();
            d[i] = in.nextInt();
        }
        System.out.println(solve());
    }
}
