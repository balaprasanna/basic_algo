import java.lang.Math;

public class Board{
    private int[][] blocks;
    private int N;
    private int h;
    private int m;
    // construct a board from an N-by-N array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks){
        this.blocks = blocks;
        this.N = blocks.length;
        this.h = null;
        this.m = null;
    }
    // board dimension N
    public int dimension(){
        return N;
    }
    // distance: number of blocks out of place
    public int hamming(){
        if (h != null) return h;
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
    }
    // distance: sum of Manhattan distances between blocks and goal
    public int manhattan(){
        int m = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++){
                int x = blocks[i][j]/N - 1;
                int y = blocks[i][j]%N - 1;
                m = m + Math.abs(x-i) + Math.abs(y-j);
            }
        return m;
    }
    // is this board the goal board?
    public boolean isGoal(){ return this.hamming() == 0;}
    // a board obtained by exchanging two adjacent blocks in the same row
    public Board twin(){
        int[][] newb = new int[N][N];
        makeCopy(newb);
        
        boolean ch = false;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++)
            if (blocks[i][j] != 0 && (j+1 < N) && blocks[i][j+1] != 0){
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
    public boolean equals(Object y){
        Board other = (Board) y;
        return this.toString().equals(other.toString());
    }
    // all neighboring boards
    public Iterable<Board> neighbors(){
        Queue nq = new Queue();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (blocks[i][j] == 0){
                    
                    if (i > 0)
                    {
                        int[][] newb = new int[N][N];
                        makeCopy(newb);
                        newb[i][j] = newb[i-1][j];
                        newb[i-1][j] = 0;
                        nq.enqueue(new Board(newb));
                    }
                    if (j > 0)
                    {
                        int[][] newb = new int[N][N];
                        makeCopy(newb);
                        newb[i][j] = newb[i][j-1];
                        newb[i][j-1] = 0;
                        nq.enqueue(new Board(newb));
                    }
                    if (i < N-1)
                    {
                        int[][] newb = new int[N][N];
                        makeCopy(newb);
                        newb[i][j] = newb[i+1][j];
                        newb[i+1][j] = 0;
                        nq.enqueue(new Board(newb));
                    }
                    if (j < N-1)
                    {
                        int[][] newb = new int[N][N];
                        makeCopy(newb);
                        newb[i][j] = newb[i][j+1];
                        newb[i][j+1] = 0;
                        nq.enqueue(new Board(newb));
                    }
                    break;
                    }
        return nq;
    }
    // string representation of the board (in required output format)
    public String toString(){
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
    private void makeCopy(int[][] newb){
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
            newb[i][j] = blocks[i][j];
    }
}