import java.io.*;
import java.util.*;
//伪装成c++的读入
class cin
{
static int leave=0;
static StringTokenizer st;
static BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
static int nextInt() throws Exception
{
    while (leave==0)
    {
     st=new StringTokenizer(in.readLine());
     leave=st.countTokens();
    }
    leave--;
    return Integer.parseInt(st.nextToken());
}
}

class Edge implements Comparable<Edge>{
    int x;
    int y;
    int weight;
    void init(int x, int y, int weight){
        this.x = x;
        this.y = y;
        this.weight = weight;
    }
    public int compareTo(Edge o){
        return o.weight - this.weight;
    }
}
public class P3723 {
    private static int N;//girls
    private static int M; // boys
    private static int R; //relations
    private static Edge[] edges;
    private static int[] parent;
    private static int[] rank;

    private static int solve(){
        Arrays.sort(edges); //heaviest first
        parent = new int[N+M];
        rank = new int[N+M];
        for(int i = 0; i < N+M; i++)
            parent[i] = i;
        int sum = 0;
        int ctr = 0;
        for(int i = 0; i < R && ctr<N+M; i++){
            int rx = findRoot(edges[i].x);
            int ry = findRoot(edges[i].y);
            if(rx != ry){
                sum += edges[i].weight;
                union(rx, ry);
                ctr++;
            }
        }
        return 10000*(N+M)-sum;
    }
    private static int findRoot(int x){
        if(parent[x] == x)
            return x;
        parent[x] = findRoot(parent[x]);
        return parent[x];
    }
    private static void union(int x, int y){
        if(rank[x] < rank[y])
            parent[x] = y;
        else {
            if(rank[x] == rank[y])
                rank[x]++;
            parent[y] = x;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int test = cin.nextInt();
        while(test-- > 0){
            N = cin.nextInt();
            M = cin.nextInt();
            R = cin.nextInt();
            edges = new Edge[R];
            for(int i = 0; i < R; i++){
                edges[i] = new Edge();
                edges[i].init(cin.nextInt(), cin.nextInt()+N, cin.nextInt());
            }
            System.out.println(solve());
        }
    }
}
