import java.util.Arrays;


public class ValidSudoku {
	private int[] tester = new int[10];
    public boolean isValidSudoku(char[][] board) {
        boolean result = true;
        for(int i = 0; i < 9; i++){
            result = testRow(board, i);
            if(!result) return result;
            result = testCol(board, i);
            if(!result) return result;
        }
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3;  j++){
                result = testBox(board, i, j);
                if(!result) return result;
            }
        return true;
    }
    private boolean testRow(char[][] board, int x){
        Arrays.fill(tester, 0);
        int y = 0;
        for(int j = 0; j < 9; j++){
            if(board[x][j]!= '.'){
                y =board[x][j]-'0';
                if(y < 1 || y > 9) return false;
                tester[y] ++;
                if(tester[y] >1) return false;
            }
        }
        return true;
    }
    private boolean testCol(char[][] board, int y){
        Arrays.fill(tester, 0);
        int x = 0;
        for(int i = 0; i < 9; i++){
            if(board[i][y] != '.'){
                x = board[i][y]-'0';
                if(x < 1 || x > 9) return false;
                tester[x]++;
                if(tester[x] >1) return false;
            }
        }
        return true;
    }
    private boolean testBox(char[][] board, int x, int y){
        Arrays.fill(tester, 0);
        int a = 0;
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++){
                if(board[x*3+i][j+y*3] != '.'){
                    a = board[x*3+i][j+y*3]-'0';
                    if(a < 1 || a > 9) return false;
                    tester[a]++;
                    if(tester[a] > 1) return false;
                }
            }
        return true;
    }
}
