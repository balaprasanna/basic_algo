//有点烦，corner cases
public class CombinationSumII {
	private List<List<Integer>> result;
    private List<Integer> sol;
    public List<List<Integer>>combinationSum2(int[] num, int target){
        Arrays.sort(num);
        result = new ArrayList<List<Integer>>();
        sol = new ArrayList<Integer>();
        if(num == null || num.length == 0) return result;
        int n = num.length;
        
        sumRec(num, target, n-1);
        return result;
    }
    private void sumRec(int[] num, int target, int pos){
        if(target == 0){
            if(sol.size()!=0) result.add(new ArrayList<Integer>(sol));
            return;
        }
        while(pos >= 0 && num[pos] > target)
            pos --;
        for(int i = pos; i >=0;){
            int nexti = i-1;
            while(nexti >= 0 && num[nexti] == num[i])
                nexti --;
            sol.add(0,num[i]);
            sumRec(num, target-num[i], i-1);
            sol.remove(0);
            
            i = nexti;
        }
    }
}
