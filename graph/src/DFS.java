//recursive DFS implementation
public class DFS {
	private int time; //global timestamping counter
	private boolean[] marked;// marked[v] whether v is visited
	private int[] parentOf; //parentOf[v]: takes down v's parent
	private int[] discoveredAt; //when v is discovered (relev. to time)
	private int[] finishedAt; //when v is finished
	//what are the above two arrays used for?
	
	public DFS(Graph G){
		this.time = 0;
		this.marked = new boolean[G.V()];
		this.parentOf = new int[G.V()];
		this.discoveredAt = new int[G.V()];
		this.finishedAt = new int[G.V()];
		for (int v = 0; v < G.V(); v++)
			marked[v] = false;
		dfsSolution(G);
	}
	public void dfsSolution (Graph G){
		for (int v = 0; v < G.V(); v++)
			if (marked[v] == true)
				dfsVisit(G,v);
	}
	public void dfsVisit(Graph G, int s){
		time++;
		marked[s] = true;
		discoveredAt[s] = time;
		for (int u: G.adj[s])
			if (!marked[u]){
				parentOf[u] = s;
				dfsVisit(G, u);
			}
		time++;
		finishedAt[s] = time; 
	}
}
