import java.io.*;
import java.util.*;

public class P3268{
    private static int N,M,X;
    private static int[][] dist,rev;
    private static int Dijkstra(){
        int[] min = new int[N+1];
        int[] min2 = new int[N+1];
        for(int i = 1; i <= N; i++){
            min[i] = Integer.MAX_VALUE;
            min2[i] = Integer.MAX_VALUE;
        }
        min[X] = 0; min2[X] = 0;
        boolean[] used = new boolean[N+1];
        int cur = X;
        used[cur] = true;
        for(int i = 1; i < N; i++){
            int next = 0;
            int minLen = Integer.MAX_VALUE;
            for(int j = 1; j <= N; j++){
                if(!used[j] && rev[cur][j]!=0)
                    min[j] = Math.min(min[j], min[cur]+rev[cur][j]);
                if(!used[j] && min[j] < minLen){
                    minLen = min[j];
                    next = j;
                }
            }
            cur = next;
            used[cur]=true;
        }
        
        used = new boolean[N+1];
        cur = X;
        used[cur] = true;
        for(int i = 1; i < N; i++){
            int next = 0;
            int minLen = Integer.MAX_VALUE;
            for(int j = 1; j <= N; j++){
                if(!used[j] && dist[cur][j]!=0)
                    min2[j] = Math.min(min2[j], min2[cur]+dist[cur][j]);
                if(!used[j] && min2[j] < minLen){
                    minLen = min2[j];
                    next = j;
                }
            }
            cur = next;
            used[cur]=true;
        }
        int ret =0;
        for(int i = 1; i <= N; i++)
            ret = Math.max(ret, min[i]+min2[i]);
        return ret;
    }
    public static void main(String[] args) throws IOException{
        Scanner in=new Scanner(System.in);
        N = in.nextInt();//farms
        M = in.nextInt();//road
        X = in.nextInt();//destination
        dist = new int[N+1][N+1];
        rev = new int[N+1][N+1];
        int x,y,t;
        for(int i = 0; i < M; i++){
            x = in.nextInt();
            y = in.nextInt();
            t = in.nextInt();
            dist[x][y] = t;
            rev[y][x] = t;
        }
        System.out.println(Dijkstra());
    }
}