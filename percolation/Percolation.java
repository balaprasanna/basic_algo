public class Percolation {
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF uf2;
    private boolean[][] openstate; // false->closed true->open
    private int N;
    // create N-by-N grid, with all sites blocked
    public Percolation(int Num){
        N=Num;
        //initialize all site to closed
        openstate = new boolean[N][N];
        //fullstate = new boolean[N][N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++){
            openstate[i][j]=false;
        }
        uf = new WeightedQuickUnionUF(N*N+2);
        uf2 = new WeightedQuickUnionUF(N*N+1);
        for(int j=1;j<N+1;j++)
        {
            uf.union(0,xyTo1D(1,j));//virtual top
            uf.union(N*N+1,xyTo1D(N,j)); //virtual bottom
            uf2.union(0,xyTo1D(1,j));//only virtual top
        }
    }
    
    // open site (row i, column j) if it is not already
    public void open(int i, int j){
        valid(i,j); 
        openstate[i-1][j-1] = true; //make the site to be open
        int me = xyTo1D(i,j); //mapping from 2D to 1D
        if(i>1 && isOpen(i-1,j)) {uf.union(me,xyTo1D(i-1,j));uf2.union(me,xyTo1D(i-1,j));}
        if(j>1 && isOpen(i,j-1)) {uf.union(me,xyTo1D(i,j-1));uf2.union(me,xyTo1D(i,j-1));}   
        if(i<N && isOpen(i+1,j)) {uf.union(me,xyTo1D(i+1,j));uf2.union(me,xyTo1D(i+1,j));}
        if(j<N && isOpen(i,j+1)) {uf.union(me,xyTo1D(i,j+1));uf2.union(me,xyTo1D(i,j+1));}
    }
    // is site (row i, column j) open?
    public boolean isOpen(int i, int j){
        valid(i,j);
        return openstate[i-1][j-1];
    }
    // is site (row i, column j) full?
    public boolean isFull(int i, int j){
        valid(i,j);
        return (uf2.connected(xyTo1D(i,j),0) && isOpen(i,j));
    }
    // does the system percolate?
    public boolean percolates(){
        if(N==1)
            return isFull(1,1);
        else 
            return uf.connected(0,N*N+1);
    }
    //mapping from 2D to 1D UF index
    private int xyTo1D(int i, int j){
        return (i-1)*N+j;
    }
    //test the validation of given index
    private void valid(int i,int j){
        if (i <= 0 || i > N) throw new IndexOutOfBoundsException("row index i out of bounds");
        if (j <= 0 || j > N) throw new IndexOutOfBoundsException("row index j out of bounds");
    }
    //main for test, will be deleted later
//    public static void main(String[] args){
//        int N = StdIn.readInt();
//        Percolation per  = new Percolation(N);
//        while (!StdIn.isEmpty()) {
//            int p = StdIn.readInt();
//            int q = StdIn.readInt();
//            per.open(p,q);
//        }
//    }
    
}