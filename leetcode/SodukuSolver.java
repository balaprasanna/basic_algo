
public class SodukuSolver {
	private char[][] b;
    private int n;
    public void solveSudoku(char[][] board) {
        if (board == null) return;
        n = board[0].length;
        b = board;
        solveRecursive(0,0);
    }
    private boolean solveRecursive(int i, int j){
        int nexti = (j == n-1)? i+1: i;
        int nextj = (j+1) % n;
        
        if(i == n) return true;
        
        if(b[i][j] == '.'){
            for(char x = '1'; x <= '9'; x++){
                if(check(x, i,j)){
                    b[i][j] = x;
                    if(solveRecursive(nexti, nextj)) return true;
                    b[i][j] = '.';
                }
            }
            return false;
        }else{
            return solveRecursive(nexti, nextj);
        }
    }
    private boolean check(char c, int i,int j){
        for(int p = 0; p < n; p++){
            if(b[i][p] == c) return false;
            if(b[p][j] == c) return false;
        }
        int basex = i/3 * 3;
        int basey = j/3 * 3;
        for(int x = 0; x < 3; x++)
            for(int y = 0; y <3; y++){
                if(b[basex+x][basey+y] == c) return false;
            }
        return true;
    }
}
