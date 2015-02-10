import java.io.*;
import java.util.*;

public class P2385{
    private static int[] trees;
    private static int[][] rets;
    private static int T,W;
    private static int solve(int w, int t){
        if(rets[w][t] != -1)
            return rets[w][t];
        if(t >= T)
            return 0;
        if(trees[t] == w%2+1)
            return rets[w][t] = 1+solve(w,t+1);
        else{
            if(w == 0)
                return rets[w][t] = solve(w,t+1);
            else
                return rets[w][t] = Math.max(solve(w,t+1), 1+solve(w-1, t+1));
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        T = in.nextInt();
        W = in.nextInt();
        trees = new int[T];
        for(int i = 0; i<T; i++)
            trees[i] = in.nextInt();
        rets = new int[W+1][T+1];
        for(int i = 0; i <= W; i++)
            for(int j = 0; j <= T; j++)
                rets[i][j] = -1;
        solve(W, 0);
        System.out.println(rets[W][0]);
        
    }
}