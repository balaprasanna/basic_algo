import java.util.Arrays;

public class Board {
    private int[][] blocks;
    private int N;
    //private int h;
    private int m;
    // construct a board from an N-by-N array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks) {
        this.blocks = blocks;
        this.N = blocks.length;
        //this.h = -1;
        this.m = -1;
        manhattan();
    }
    private Board(int[][] blocks, int manh){
        this.blocks = blocks;
        this.N = blocks.length;
        this.m = manh;
    }
    // board dimension N
    public int dimension() {
        return N;
    }
    // distance: number of blocks out of place
    /*
    public int hamming() {
        if (h > -1) return h;
        h = 0;
        int correct = 1;
        int fin = N*N;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
        {
            if (blocks[i][j] != correct) h++;
            correct++;
        }
        h--; //minus the '0' in wrong position
        return h;
    }*/
    // distance: sum of Manhattan distances between blocks and goal
    public int manhattan() {
        if (m > -1) return m;
        m = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (blocks[i][j] > 0) {
                    int x = (blocks[i][j] - 1)/N;
                    int y = (blocks[i][j] - 1) % N;
                    m = m + Math.abs(x-i) + Math.abs(y-j);
                }
        return m;
    }
    // is this board the goal board?
    public boolean isGoal() { return this.m == 0; }
    // a board obtained by exchanging two adjacent blocks in the same row
    public Board twin() {
        int[][] newb = new int[N][N];
        makeCopy(newb);
        
        boolean ch = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
            if (blocks[i][j] != 0 && (j+1 < N) && blocks[i][j+1] != 0) {
                newb[i][j] = blocks[i][j+1];
                newb[i][j+1] = blocks[i][j];
                ch = true;
                break; 
            }
            if (ch) break;
        }
        return (new Board(newb));
    }
    // does this board equal y?
    public boolean equals(Object y) {
        if (y == null) return false;
        if (y == this) return true;
        if (this.getClass() != y.getClass()) return false;
        Board that = (Board) y;
        //TODO: modification
        //return this.toString().equals(other.toString());
        if (this.m != that.m) return false;
        if (this.N != that.N) return false;
        for (int i = 0; i < N; i++)
            if (! Arrays.equals(this.blocks[i], that.blocks[i]))
                return false;
        return true;
    }
    // all neighboring boards
    public Iterable<Board> neighbors() {
        Queue<Board> nq = new Queue<Board>();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (blocks[i][j] == 0) {
                    int[][] newb;
                    int x, y;
                    int newManh;
                    Board newBoard;
                    if (i > 0)
                    {
                        newb = new int[N][N];
                        makeCopy(newb);
                        newb[i][j] = newb[i-1][j];
                        newb[i-1][j] = 0;
                        //update manhattan distance
                        x = (newb[i][j] - 1)/N;
                        newManh = m - Math.abs(x-i+1) + Math.abs(x-i);
                        newBoard = new Board(newb, newManh);
                        nq.enqueue(newBoard);
                    }
                    if (j > 0)
                    {
                        newb = new int[N][N];
                        makeCopy(newb);
                        newb[i][j] = newb[i][j-1];
                        newb[i][j-1] = 0;
                        //update manhattan distance
                        y = (newb[i][j] - 1)%N;
                        newManh = m - Math.abs(y-j+1) + Math.abs(y-j);
                        newBoard = new Board(newb, newManh);
                        nq.enqueue(newBoard);
                    }
                    if (i < N-1)
                    {
                        newb = new int[N][N];
                        makeCopy(newb);
                        newb[i][j] = newb[i+1][j];
                        newb[i+1][j] = 0;
                        //update manhattan distance
                        x = (newb[i][j] - 1)/N;
                        newManh = m - Math.abs(x-i-1) + Math.abs(x-i);
                        newBoard = new Board(newb, newManh);
                        nq.enqueue(newBoard);
                    }
                    if (j < N-1)
                    {
                        newb = new int[N][N];
                        makeCopy(newb);
                        newb[i][j] = newb[i][j+1];
                        newb[i][j+1] = 0;
                        //update manhattan distance
                        y = (newb[i][j] - 1)%N;
                        newManh = m - Math.abs(y-j-1) + Math.abs(y-j);
                        newBoard = new Board(newb, newManh);
                        nq.enqueue(newBoard);
                    }
                    break;
                    }
        return nq;
    }
    // string representation of the board (in required output format)
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", blocks[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }
    private void makeCopy(int[][] newb) {
        for (int i = 0; i < N; i++)
            //for (int j = 0; j < N; j++)
            //newb[i][j] = blocks[i][j];
            System.arraycopy(blocks[i], 0, newb[i], 0, N);
    }
}