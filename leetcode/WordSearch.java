//DFS
public class WordSearch {
	private static boolean[][] used;
    public static boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) return true;
        int m = board.length;
        int n = board[0].length;
        used = new boolean[m][n]; //default initialized as false
        int len =  word.length();
        if(len > m*n) return false;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                char cur = word.charAt(0);
                if(board[i][j] == cur){
                    used[i][j] = true;
                    if(word.length() == 1) return true;
                    else if(solveRec(board, i, j, word, 1) )return true;
                    else
                        used[i][j] = false;
                }
            }
        return false;
    }
    private static boolean solveRec(char[][] board, int i, int j, String word, int index){
        if(index == word.length())
            return true;
        char cur = word.charAt(index);
        if(i != 0 && !used[i-1][j] && board[i-1][j] == cur){
            used[i-1][j] = true;
            if(solveRec(board, i-1, j, word, index+1))
                return true;
            else
                used[i-1][j] = false;
        }
        if(i != board.length -1 && !used[i+1][j] && board[i+1][j] == cur){
            used[i+1][j] = true;
            if(solveRec(board, i+1, j, word, index+1))
                return true;
            else
                used[i+1][j] = false;
        }
        if(j != board[0].length -1 && !used[i][j+1] && board[i][j+1] == cur){
            used[i][j+1] = true;
            if(solveRec(board, i, j+1, word, index+1))
                return true;
            else
                used[i][j+1] = false;
        }
        if(j != 0 && !used[i][j-1] && board[i][j-1] == cur){
            used[i][j-1] = true;
            if(solveRec(board, i, j-1, word, index+1))
                return true;
            else
                used[i][j-1] = false;
        }
        return false;
    }
    public static void main(String[] args){
    	char[][] board = {{'a','b'}};
    	String word = "ab";
    	System.out.print(exist(board, word));
    }
}
