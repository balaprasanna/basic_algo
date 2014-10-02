
public class PascalTriangle2 {
	public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> sol = new ArrayList<Integer>();
        if(rowIndex <= 0) return sol;
        sol.add(1);
        if(rowIndex == 1) return sol;
        List<Integer> cur = null;
        while(rowIndex >1){
            cur = new ArrayList<Integer>();
            cur.add(1);
            for(int i = 1; i <sol.size(); i++)
                cur.add(sol.get(i-1)+sol.get(i));
            cur.add(1);
            sol = cur;
            rowIndex--;
        }
        return sol;
    }
}
