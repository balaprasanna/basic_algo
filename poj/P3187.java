import java.io.*;
import java.util.*;

public class P3187 {
    private static int N;
    private static int sum;
    private static int[] ar;
    private static boolean[] used;
    private static boolean DFS(int level){
        if(level == N){
            //finish arrangement
            int test = 0;
            for(int i = 0; i < N; i++)
                test += ar[i]*fac(N-1, i);
            if(test == sum)
                return true;
            else 
                return false;
        }else{
            for(int i = 0; i <N; i++){
                if(!used[i]){
                    used[i] = true;
                    ar[level] = i+1;
                    boolean ret = DFS(level+1);
                    if(ret) return ret;
                    used[i] = false;
                }
            }
        }
        return false;
    }
    private static int fac(int n, int k){
        if(k == 0|| k == n) return 1;
        if(n-k < k)
            k = n-k;
        int ret = 1;
        for(int i = 0; i < k; i++)
            ret *= (n-i);
        for(int i = 0; i<k; i++)
            ret = ret/(i+1);
        return ret;
    }
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        sum = in.nextInt();
        ar = new int[N];
        used = new boolean[N];
        DFS(0);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++)
            sb.append(ar[i]+" ");
        System.out.println(sb.toString().trim());
    }
}
