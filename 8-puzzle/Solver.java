import java.util.Comparator;

public class Solver {
    //find a solution to the initial board(A* algorithm)
    //must use MinPQ from alg4.jar
    private boolean isSolvable;
    private int moves;
    private Stack solution;
    public Solver(Board initial) {
        MinPQ<SearchNode> pq = new MinPQ<SearchNode>();
        MinPQ<SearchNode> pqTwin = new MinPQ<SearchNode>();
        SearchNode initNode = new SearchNode (initial);
        SearchNode twinInitNode = new SearchNode (initial.twin());
        pq.insert(initNode);
        pqTwin.insert(twinInitNode);
        Board test= pq.min().bd;
        while (!pq.min().bd.isGoal() && !pqTwin.min().bd.isGoal()) {
            SearchNode rm = pq.delMin();
            if (rm.pre == null) {
                for (Board neighbour : rm.bd.neighbors() ){
                    SearchNode newNode = new SearchNode(neighbour, rm, 1);
                    pq.insert(newNode);
                }      
            } else {
                for (Board neighbour : rm.bd.neighbors() )
                    if (!neighbour.equals(rm.pre.bd)){
                        SearchNode newNode = new SearchNode(neighbour, rm, rm.moves+1);
                        pq.insert(newNode); 
                    }
            }
            
            SearchNode rmTwin = pqTwin.delMin();
            if (rmTwin.pre == null) {
                for (Board neighbour : rmTwin.bd.neighbors() ){
                    SearchNode newNode = new SearchNode(neighbour, rmTwin, 1);
                    pqTwin.insert(newNode);
                }      
            } else {
                for (Board neighbour : rmTwin.bd.neighbors() )
                    if (!neighbour.equals(rmTwin.pre.bd)){
                        SearchNode newNode = new SearchNode(neighbour, rmTwin, rmTwin.moves+1);
                        pqTwin.insert(newNode); 
                    }
            }
        }
        Board test2 = pqTwin.min().bd;
        if (pqTwin.min().bd.isGoal()) 
        {
            isSolvable = false;
            moves = -1;
        }else {
            isSolvable = true;
            SearchNode sn = pq.min();
            moves = sn.moves;
            solution = new Stack<Board>();
            for (int i = 0; i <= moves; i++)
            {
                solution.push(sn.bd);
                sn = sn.pre;
            } 
        }      
    }
    //is the initial board solvable?
    public boolean isSolvable() { return isSolvable; }
    //min number of moves, -1 of no solution
    public int moves() { return moves; }
    //sequence of boards in a shortest solution, null of no solution
    public Iterable<Board> solution() { return solution; }
    //solve a slider puzzle
    public static void main(String[] args) {
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
    private class SearchNode implements Comparable {
        public Board bd;
        public SearchNode pre;       
        public int moves;
        
        public SearchNode (Board bd) {
            this.bd = bd;
            this.pre = null;
            this.moves = 0;
        }
        
        public SearchNode (Board bd, SearchNode pre, int moves) {
            this.bd = bd;
            this.pre = pre;
            this.moves = moves;
        }
        /*
        public int hPriority () {
            return this.moves + this.bd.hamming();
        }*/
        
        public int mPriority () {
            return this.moves + this.bd.manhattan();
        }
         
        public int compareTo (Object other) {
            SearchNode y = (SearchNode) other;
            if (this ==  other) return 0;
            int xp = this.mPriority();
            int yp = y.mPriority();
            if (xp > yp) return 1;
            if ( xp == yp) return 0;
            return -1;
        }
    }
}