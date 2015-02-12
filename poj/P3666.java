import java.io.*;
import java.util.*;

public class P3666{
    private static int N;
    private static int[] heights, sorted;
    private static int[][] cost;
    //这是n^3的recursive dp,需要降复杂度，index都要减一
    private static int solve(int i, int h){
        if(cost[i][h]!= Integer.MAX_VALUE)
            return cost[i][h];
        int cur = heights[i];
        int target = heights[h];
        for(int k = 1; k <=N; k++)
            if(heights[k] <= target)
                cost[i][h] = Math.min(cost[i][h], solve(i-1, k)+ Math.abs(target-cur));
        return cost[i][h];
        
    }
    /*
    private static int solve2(int i, int h){
        if(cost[i][h]!= Integer.MAX_VALUE)
            return cost[i][h];
        int cur = heights[i];
        int target = heights[h];
        for(int k = 1; k <=N; k++)
            if(heights[k] >= target)
                cost[i][h] = Math.min(cost[i][h], solve(i-1, k)+ Math.abs(target-cur));
        return cost[i][h];
    }
    */
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        N = in.nextInt();
        heights = new int[N];
        for(int i =0; i < N; i++)
            heights[i] = in.nextInt();
        sorted = Arrays.copyOf(heights, N);
        Arrays.sort(sorted);
        //insight, to reduce cost, we won't create a new height
        cost = new int[N][N];
        //这是填表dp,复杂度dp
        for(int i = 0; i < N; i++)
            cost[0][i] = Math.abs(heights[0]-sorted[i]);
        for(int i = 1; i < N; i++){
            int min = cost[i-1][0];
            for(int j = 0; j < N; j++){
                min = Math.min(min, cost[i-1][j]);
                cost[i][j] = min + Math.abs(heights[i]-sorted[j]);
            }
        }
            
        int ret = Integer.MAX_VALUE;
        //non-dec slope
        for(int h = 0; h < N; h++)
            ret = Math.min(ret, cost[N-1][h]);
        //non-inc slope,weak data, save time
        /*
        cost = new int[N+1][N+1];
        for(int i = 1; i <= N; i++)
            for(int j =1; j <= N; j++)
                cost[i][j] = Integer.MAX_VALUE;
        for(int h = 1; h <= N; h++)
            ret = Math.min(ret, solve2(N,h));
       */
        System.out.println(ret);
    }
}