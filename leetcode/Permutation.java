import java.util.ArrayList;
import java.util.List;


public class Permutation {
	private boolean[] used;
    private List<List<Integer>> result;
    private List<Integer> item;
    public List<List<Integer>> permute(int[] num) {
        item = new ArrayList<Integer>();
        result = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) return result;
        if(num.length == 1){
            item.add(num[0]);
            result.add(item);
            return result;
        }
        
        int n = num.length;
        used = new boolean[n];
        solveRec(num, n);
        
        return result;
    }
    private void solveRec(int[] num, int left){
        int n = num.length;
        if(left == 0){
            result.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i = 0; i<n ; i++)
            if(!used[i]){
                used[i] = true;
                item.add(num[i]);
                solveRec(num, left-1);
                used[i] = false;
                item.remove(n-left);
            }
    }
}
