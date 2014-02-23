public class PercolationStats {
    private Percolation per;
    private double[] thresholds;
    private int counter;
    private double total;
    private int N;
    private int T;
    // perform T independent computational experiments on an N-by-N grid
    public PercolationStats(int Num, int Time){
        N=Num;T=Time;
        valid(N,T);
        thresholds = new double[T];//array for storing thresholds
        total = N*N;//total number of sites
        int i,j; //randomly generated coordinates
        for(int k=0; k<T; k++){
            counter = 0;
            per = new Percolation(N);
            while(!per.percolates()){
                i=StdRandom.uniform(N)+1;
                j=StdRandom.uniform(N)+1;
                while(per.isOpen(i,j)){
                    i=StdRandom.uniform(N)+1;
                    j=StdRandom.uniform(N)+1;
                }
                per.open(i,j);
                counter++;
            }
            thresholds[k]=counter/total;
            per = null;
        }
    }
    // sample mean of percolation threshold
    public double mean(){
        return StdStats.mean(thresholds);
    }
    // sample standard deviation of percolation threshold
    public double stddev(){
        return StdStats.stddev(thresholds);
    }
    // returns lower bound of the 95% confidence interval
    public double confidenceLo(){
        return (mean() - 1.96* stddev()/Math.sqrt(T));
    }
    // returns upper bound of the 95% confidence interval
    public double confidenceHi(){
        return (mean() + 1.96* stddev()/Math.sqrt(T));
    }  
    //private method to test the validation of N and T
    private void valid(int N,int T){
        if (N <= 0) throw new IllegalArgumentException("not valid N");
        if (T <= 0) throw new IllegalArgumentException("not valid T");
    }
    // test client, described below
    public static void main(String[] args){
        int N =Integer.parseInt(args[0]);
        int T =Integer.parseInt(args[1]);
        PercolationStats p = new PercolationStats(N,T);
        StdOut.printf("mean                    = %.16f\n",p.mean());
        StdOut.printf("stddev                  = %.16f\n",p.stddev());
        StdOut.printf("95%% confidence interval = %.16f, %.16f\n",p.confidenceLo(),p.confidenceHi());
    }
}