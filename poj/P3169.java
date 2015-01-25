import java.io.*;
import java.util.*;
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

class Edge {
    int from;
    int to;
    int weight;
    void init(int from, int to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
public class P3169 {
    private static int N;
    private static int E;
    private static Edge[] edges;
    
    private static int BellmanFord(){
        int[] distance = new int[N];
        for(int i = 1; i < N; i++)
            distance[i] = Integer.MAX_VALUE;
        
        for(int i = 0; i <N-1; i++)
            for(Edge e: edges)
                if(distance[e.from] != Integer.MAX_VALUE)
                    distance[e.to] = Math.min(distance[e.to], distance[e.from]+e.weight);
        
        for(Edge e: edges){
            if(distance[e.from]!= Integer.MAX_VALUE && distance[e.from]+e.weight < distance[e.to])
                return -1; //no feasible solution
        }
        if(distance[N-1] == Integer.MAX_VALUE)
            return -2;
        return distance[N-1];
    }
    public static void main(String[] args) throws Exception {
        N = cin.nextInt();
        int ml = cin.nextInt();
        int md = cin.nextInt();
        E = N-1 + ml + md;
        edges = new Edge[E];
        for(int i=0; i<N-1; i++){
            edges[i] = new Edge();
            edges[i].init(i+1, i, 0);
        }
        for(int i = 0; i < ml; i++){
            edges[i+N-1] = new Edge();
            edges[i+N-1].init(cin.nextInt()-1, cin.nextInt()-1, cin.nextInt());
        }
        for(int i = 0; i < md; i++){
            edges[i+N-1+ml] = new Edge();
            int A = cin.nextInt()-1;
            int B = cin.nextInt()-1;
            edges[i+N-1+ml].init(B, A, - cin.nextInt());
        }
        System.out.println(BellmanFord());
    }
}
