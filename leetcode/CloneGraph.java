
public class CloneGraph {
	//first time, 卧槽写的好麻烦
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<Integer, UndirectedGraphNode> hmap = new HashMap<>();
        HashMap<Integer, Boolean> hfin = new HashMap<>();
        Queue<UndirectedGraphNode> qu = new LinkedList<UndirectedGraphNode>();
        if(node == null) return null;
        UndirectedGraphNode first = new UndirectedGraphNode(node.label);
        hmap.put(node.label,first);
        while(node!=null){
            UndirectedGraphNode cur = hmap.get(node.label);
            hfin.put(cur.label, true);
            for(UndirectedGraphNode neighbor: node.neighbors){
                if(hmap.get(neighbor.label) == null)
                    hmap.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                //if(!cur.neighbors.contains(hmap.get(neighbor.label)))
                cur.neighbors.add(hmap.get(neighbor.label));
                if(hfin.get(neighbor.label) == null)
                    qu.add(neighbor);
            }
            node = qu.poll();
            while(node != null && hfin.get(node.label)!=null)
                node = qu.poll(); 
        }
        
        return first;
    }
	//with thought of BFS
	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hmap = new HashMap<>();
        Queue<UndirectedGraphNode> qu = new LinkedList<UndirectedGraphNode>();
        
        UndirectedGraphNode first = new UndirectedGraphNode(node.label);
        hmap.put(node,first);
        qu.add(node);
        while(qu.size()!= 0){
            node = qu.poll();
            UndirectedGraphNode curr = hmap.get(node);
            for(UndirectedGraphNode neighbor: node.neighbors){
                if(hmap.get(neighbor) == null){
                    hmap.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    qu.add(neighbor);
                }
                curr.neighbors.add(hmap.get(neighbor));
            }
        }
        return first;
    }
}
