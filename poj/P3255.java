import java.io.*;
import java.util.*;

public class P3255 {
    private static int r; //edges
    private static int n; //vertices
    private static List<List<edge>> adj;
    private static int modDijkstra(){
        int[] min = new int[n];
        int[] min2 = new int[n];
        boolean[] used = new boolean[n];
        for(int i = 0; i<n; i++){
            min[i] = Integer.MAX_VALUE;
            min2[i] = Integer.MAX_VALUE;
        }
        min[0] = 0;
        int cur = 0;
        for(int i = 0; i<n-1; i++){
            used[cur] = true;
            int curMin = Integer.MAX_VALUE;
            int nextCur = 0;
            for(edge e : adj.get(cur)){
                if(!used[e.dest] )
                    min[e.dest] = Math.min(min[e.dest], min[cur]+ e.dist);
                if(!used[e.dest] && curMin > min[e.dest]){
                    curMin = min[e.dest];
                    nextCur = e.dest;
                }    
            }
            cur = nextCur;
        }
        //from n to 1
        used = new boolean[n];
        min2[n-1] = 0;
        cur = n-1;
        for(int i = 0; i<n-1; i++){
            used[cur] = true;
            int curMin = Integer.MAX_VALUE;
            int nextCur = 0;
            for(edge e : adj.get(cur)){
                if(!used[e.dest] )
                    min2[e.dest] = Math.min(min2[e.dest], min2[cur]+ e.dist);
                if(!used[e.dest] && curMin > min2[e.dest]){
                    curMin = min2[e.dest];
                    nextCur = e.dest;
                }    
            }
            cur = nextCur;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i <n; i++)
            for(edge e: adj.get(i)){
                    int tmp = min[i]+ e.dist +min2[e.dest];
                    if(tmp == min[n-1])
                        continue;
                    res = Math.min(res, tmp);
            }
        return res;
    }
    class edge{
        int dest;
        int dist;
        public edge(int dest, int dist){
            this.dest = dest;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        P3255 m = new P3255();
        Scanner in=new Scanner(System.in);
        n = in.nextInt();
        r = in.nextInt();
        adj = new ArrayList<List<edge>>(n);
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<edge>());
        int x,y,weight;
        for(int i = 0; i <r; i++){
            x = in.nextInt()-1;
            y = in.nextInt()-1;
            weight = in.nextInt();
            adj.get(x).add(m.new edge(y,weight));
            adj.get(y).add(m.new edge(x,weight));
        }
        System.out.println(modDijkstra());
    }
}
