import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Graph {
	private final int V;
	private int E;
	List<Integer>[] adj;
	
	@SuppressWarnings("unchecked")
	public Graph(int V) throws Exception{
		if (V < 0) throw new Exception("Number of vertices must be nonnegative.");
		this.V = V;
		this.E = 0;
		adj = (List<Integer>[]) new List[V];
		for (int v = 0; v < V; v++)
			adj[v] = new ArrayList<Integer>();
	}
	
	public Graph(Graph G) throws Exception{
		this(G.V());
		this.E = G.E();
		for (int v = 0; v < G.V(); v++){
			for (int w: G.adj[v])
				this.adj[v].add(w);
		}
	}
	public void addEdge(int v, int w){
		if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
        if (w < 0 || w >= V) throw new IndexOutOfBoundsException();
        E++;
        adj[v].add(w);
        adj[w].add(v);
	}
	//getter
	public int V(){
		return this.V;
	}
	public int E(){
		return this.E;
	}
}
