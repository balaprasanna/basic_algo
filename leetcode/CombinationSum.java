import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//去重的问题要好好想一想，不要想多了

public class CombinationSum {
	private static List<List<Integer>> result;
    private static List<Integer> sol;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
        sol = new ArrayList<Integer>();
        result = new ArrayList<List<Integer>>();
        int n = candidates.length;
        sumRec(candidates, target, n-1);
        return result;
    }
    private static void sumRec(int[] cand, int target, int pos){
        if(target == 0){
            if(sol.size()!=0) result.add(new ArrayList<Integer>(sol));
        }
        while(pos >= 0 && cand[pos] > target)
            pos--;
        
        for(int i = pos; i >= 0; i--){
            sol.add(0, cand[i]);
            sumRec(cand, target-cand[i], i);
            sol.remove(0);
        }
    }
    public static void main(String[] args){
    	int[] cand = {1,2,3,4};
    	int target = 9;
    	System.out.print(combinationSum(cand, target));
    }
}
