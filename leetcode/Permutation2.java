import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Permutation2 {
	private boolean[] used;
    private List<List<Integer>> result;
    private List<Integer> sol;
    public List<List<Integer>> permuteUnique(int[] num) {
        result = new ArrayList<List<Integer>>();
        sol = new ArrayList<Integer>();
        if(num == null || num.length == 0) return result;
        Arrays.sort(num);
        int n = num.length;
        used = new boolean[n];
        solveRec(num, n);
        return result;
    }
    private void solveRec(int[] num, int left){
        if(left == 0){
            result.add(new ArrayList<Integer>(sol));
            return;
        }
        int n = num.length;
        for(int i =0; i < n; i++){
            if(!used[i]){
                used[i] = true;
                sol.add(num[i]);
                solveRec(num, left-1);
                used[i] = false;
                sol.remove(n-left);
                while(i< n-1 && num[i] == num[i+1])
                    i++;
            }
        }
    }
}
