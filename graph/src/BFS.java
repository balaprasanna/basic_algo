import java.util.LinkedList;
import java.util.Queue;

//basic algo
public class BFS {
	private static final int INF = Integer.MAX_VALUE;
	private boolean[] marked;//marked[v]: is there a s-v path
	private int[] distTo; //distTo[V]: dist s-v
	private int[] parent;//parent[v]: parent of v
	
	public BFS(Graph G, int s){
		this.marked = new boolean[G.V()];
		this.distTo = new int[G.V()];
		this.parent = new int[G.V()];
		bfs(G,s);
	}
	
	public void bfs (Graph G, int s){
		for (int v = 0; v < G.V(); v++){
			this.marked[v] = false;
			this.distTo[v] = INF;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		marked[s] = true;
		distTo[s] = 0;
		while (!q.isEmpty()){
			int u = q.remove();
			for (int v: G.adj[u]){
				if (!marked[v]){
					marked[v] = true;
					distTo[v] = distTo[u]+1;
					parent[v] = u;
					q.add(v);
				}
			}
		}	
	}
}
