import java.util.LinkedList;
import java.util.Queue;
//BFS的应用，还需要加强

public class SurroundedRegions {
	Queue<Integer> qu;
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;
        qu = new LinkedList<Integer>();
        //BFS from 4 boards
        for(int j = 0; j < n; j++){
            enQueue(board, 0, j);
            enQueue(board, m-1, j);
        }
        for(int i = 0; i < m; i++){
            enQueue(board, i, 0);
            enQueue(board, i, n-1);
        }
        BFS(board);
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'D')
                    board[i][j] = 'O';
            }
    }
    private void enQueue(char[][] board, int i, int j){
        if(i<0 || i>= board.length || j < 0|| j >=board[0].length || board[i][j]!='O' )
            return;
        qu.add(j+i*board[0].length);
        board[i][j] = 'D'; //determined that this position is not surrounded
    }
    private void BFS(char[][] board){
        int n = board[0].length;
        while(qu.size() > 0){
            int cur = qu.poll();
            int x = cur/n;
            int y = cur%n;
            enQueue(board, x-1, y);
            enQueue(board, x+1, y);
            enQueue(board, x, y-1);
            enQueue(board, x, y+1);
        }
    }
}
