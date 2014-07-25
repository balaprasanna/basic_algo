public class Solver{
    //find a solution to the initial board(A* algorithm)
    //must use MinPQ from alg4.jar
    public Solver(Board initial){}
    //is the initial board solvable?
    public boolean isSolvable(){}
    //min number of moves, -1 of no solution
    public int moves(){}
    //sequence of boards in a shortest solution, null of no solution
    public Iterable<Board> solution(){}
    //solve a slider puzzle
    public static void main(String[] args){
        //create initial board from file
        In in = new In(args[0]);
        int N = in.readInt();
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
            blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);
        
        //solve the puzzle
        Solver solver = new Solver(initial);
        
        //print solution to standard output
        if (!solver.isSolvable)
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board: solver.solution())
                StdOut.println(board);
        }
    }
}