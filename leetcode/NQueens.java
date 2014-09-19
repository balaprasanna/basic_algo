import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode
public class NQueens {
	//iterate through rows
    private int[] perm; //perm[i] = j; queen of row (i+1) is placed on column j+1
    private boolean[] usedCol; //usedCol[i]:check whether colunm i+1 is used
    private List<String[]> result;
    public List<String[]> solveNQueens(int n) {
        result = new ArrayList<String[]>();
        if(n == 0) return result;
        //initialization
        perm = new int[n];
        Arrays.fill(perm, -1);
        usedCol = new boolean[n];
        
        fillRow(0, n);
        
        return result;
    }
    private void fillRow(int row, int n){
        if (row == n){
            char[] base = new char[n];
            Arrays.fill(base, '.');
            String[] sol = new String[n];
            for(int i = 0; i < n; i++){
                base[perm[i]] = 'Q';
                sol[i] = new String(base);
                base[perm[i]] = '.';
            }
            result.add(sol);
            return;
        }
        for(int i = 0; i < n; i++){
            if(!usedCol[i] && checkValid(row, i)){
                perm[row] = i;
                usedCol[i] = true;
                fillRow(row+1, n);
                perm[row] = -1;
                usedCol[i] = false;
            }
        }
        return;
    } 
    private boolean checkValid(int row, int i){
        for(int x = 0; x < row; x++)
            if(Math.abs(row-x) == Math.abs(i-perm[x])) return false;
        return true;
    }
}
