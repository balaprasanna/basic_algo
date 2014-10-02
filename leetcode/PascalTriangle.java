
public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<Integer>();
        if(numRows <= 0) return result;
        sol.add(1);
        result.add(sol);
        if(numRows == 1) return result;
        List<Integer> cur = null;
        while(numRows >1){
            cur = new ArrayList<Integer>();
            cur.add(1);
            for(int i = 1; i <sol.size(); i++)
                cur.add(sol.get(i-1)+sol.get(i));
            cur.add(1);
            result.add(cur);
            sol = cur;
            numRows--;
        }
        return result;
    }
}
