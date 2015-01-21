import java.io.*;
import java.util.*;

public class P1062 {
    private static int M; //grade
    private static int N; //objects
    private static int[] level;
    private static int[][] weight;
    
    public static void init(){
        level = new int[N+1];
        weight = new int[N+1][N+1];
    }
    
    private static int Dijkstra(int start, int end){
        boolean[] visited = new boolean[N+1];
        int[] cost = new int[N+1];
        for(int i = 1; i <=N; i++)
            cost[i] = Integer.MAX_VALUE;
        int cur = 0;
        for(int k = 1; k <= N; k++){
            visited[cur] = true;
            int min = Integer.MAX_VALUE;
            int nextCur = 0;
            for(int i = 1; i <= N; i++){
                if(level[i]>= start && level[i] <= end && !visited[i] ){
                    if(weight[cur][i] != 0 && cost[i] > cost[cur]+weight[cur][i])
                        cost[i] = cost[cur]+weight[cur][i];
                    if(cost[i] < min){
                        min = cost[i];
                        nextCur = i;
                    }
                }
            }
            if(nextCur == 1)
                return cost[1];
            cur = nextCur;
        }
        return cost[1];
    }

    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(System.in);
        M = in.nextInt();
        N = in.nextInt();
        init();
        for(int i = 1; i <= N; i++){
            weight[0][i] = in.nextInt();
            level[i] = in.nextInt(); //level
            int k = in.nextInt(); 
            for(int j = 1; j <= k; j++)
                weight[in.nextInt()][i] = in.nextInt();
        }
        level[0] = level[1];
        int min = Integer.MAX_VALUE;
        for(int l = 0; l <= M; l++){
            int cost = Dijkstra(level[1]-M+l,level[1]+l);
            if(min > cost)
                min = cost;
        }
        System.out.println(min);
    }
}
