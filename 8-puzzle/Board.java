public class Board{
    // construct a board from an N-by-N array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] bloacks){}
    // board dimension N
    public int dimension(){}
    // priority function: number of blocks out of place
    public int hamming(){}
    // priority function: sum of Manhattan distances between blocks and goal
    public int manhattan(){}
    // is this board the goal board?
    public boolean isGoal(){}
    // a board obtained by exchanging two adjacent blocks in the same row
    public Board twin(){}
    // does this board equal y?
    public boolean equals(Object y){}
    // all neighboring boards
    public Iterable<Board> neighbors(){}
    // string representation of the board (in required output format)
    public String toString(){}
}