import java.util.Comparator;

public class Solver{
    //find a solution to the initial board(A* algorithm)
    //must use MinPQ from alg4.jar
    private boolean isSolvable;
    private int moves;
    private Stack solution;
    public Solver(Board initial){
        MinPQ pq = new MinPQ();
        MinPQ pq_twin = new MinPQ();
        SearchNode initNode = new SearchNode (initial);
        SearchNode twinInitNode = new SearchNode (initial.twin());
        pq.insert(initNode);
        pq_twin.insert(twinInitNode);
        while ( !((SearchNode)pq.min()).getBoard().isGoal() 
                   && !((SearchNode)pq_twin.min()).getBoard().isGoal()){
            SearchNode rm = (SearchNode)pq.delMin();
            for (Board neighbour : rm.getBoard().neighbors())
                if (rm.getPre() == null || !neighbour.equals(rm.getPreviousBoard())){
                    SearchNode newNode = new SearchNode(neighbour, rm, rm.getMoves() + 1);
                    pq.insert(newNode);
                }
            SearchNode rmTwin = (SearchNode)pq_twin.delMin();
            for (Board neighbour : rmTwin.getBoard().neighbors())
                if (rmTwin.pre == null || !neighbour.equals(rmTwin.getPreviousBoard())){
                    SearchNode newNode = new SearchNode(neighbour, rmTwin, rmTwin.getMoves() + 1);
                    pq_twin.insert(newNode);
                }
        }
        if (((SearchNode)pq_twin.min()).getBoard().isGoal()) 
        {
            isSolvable = false;
            moves = -1;
        }else{
            isSolvable = true;
            SearchNode sn = (SearchNode)pq.min();
            moves = sn.getMoves();
            solution = new Stack();
            for (int i = 0; i <= moves; i++)
            {
                solution.push(sn.getBoard());
                sn = sn.getPre();
            } 
        }      
    }
    //is the initial board solvable?
    public boolean isSolvable(){ return isSolvable; }
    //min number of moves, -1 of no solution
    public int moves(){ return moves; }
    //sequence of boards in a shortest solution, null of no solution
    public Iterable<Board> solution(){ return solution; }
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
    
    //auxiliary search node
    private class SearchNode implements Comparable{
        private Board current;
        private SearchNode pre;       
        private int moves;
        
        public SearchNode (Board bd){
            this.current = bd;
            this.pre = null;
            this.moves = 0;
        }
        
        public SearchNode (Board bd, SearchNode pre, int moves){
            this.current = bd;
            this.pre = pre;
            this.moves = moves;
        }
        
        public int h_priority () {
            return this.moves + this.current.hamming();
        }
        
        public int m_priority () {
            return this.moves + this.current.manhattan();
        }
        
        public int compareTo (Object other){
            SearchNode y = (SearchNode) other;
            int xp = this.h_priority();
            int yp = y.h_priority();
            if (xp > yp) return 1;
            if ( xp == yp) return 0;
            return -1;
        }
        
        public Board getBoard() { return current; }
        public Board getPreviousBoard() { return this.pre.getBoard(); }
        public int getMoves() { return moves; }
        public SearchNode getPre() { return pre; }
    }
}