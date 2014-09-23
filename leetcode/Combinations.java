//backtracking
//DFS
public class Combinations {
	List<List<Integer>> result;
    List<Integer> item;
    public List<List<Integer>> combine(int n, int k) {
        item = new ArrayList<Integer>();
        result= new ArrayList<List<Integer>>();
        if(k > n) return result;
        solveRec(1,n,k);
        return result;
    }
    private void solveRec(int start, int end, int k){
        if(k == 0){
            result.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i = start; i <= end-k+1; i++){
            item.add(i);
            solveRec(i+1, end, k-1);
            item.remove(item.size()-1);
        }
    }
}
