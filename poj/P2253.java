import java.io.*;
import java.util.*;

public class P2253 {
    private static int n;
    private static int[] x;
    private static int[] y;
    private static double[][] ma;
    
    private static double BF(){
        ma = new double[n][n];
        for(int i = 0; i < n; i++)
            for(int j = i; j <n; j++){
                if(j == i)
                    ma[i][j] = 0;
                else{
                    ma[i][j] = dist(i,j);
                    ma[j][i] = ma[i][j];
                }
            }
        double[] step = new double[n];
        step[0] = 0;
        for(int i = 1; i < n; i++)
            step[i] = Double.MAX_VALUE;
        boolean[] visited = new boolean[n];
        int cur = 0;
        for(int k = 0; k<n; k++){
            visited[cur] = true;
            int nextCur = 0;
            double minStep = Double.MAX_VALUE;
            for(int i = 0; i < n; i++){
                if(!visited[i] && step[i] > Math.max(step[cur], ma[cur][i]))
                    step[i] = Math.max(step[cur], ma[cur][i]);
                if(!visited[i] && minStep > step[i]){
                    minStep = step[i];
                    nextCur = i;
                }
            }
            if(nextCur == 1)
                return step[1];
            cur = nextCur;
        }
        return step[1];
    }
    
    private static double dist(int i, int j){
        double d = (x[i]-x[j])*(x[i]-x[j]) + (y[i]-y[j])*(y[i]-y[j]);
        d = Math.sqrt(d);
        return d;
    }

    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(System.in);
        n = in.nextInt();
        int k = 1;
        while(n!=0){
            x = new int[n];
            y = new int[n];
            for(int i = 0; i < n; i++){
                x[i] = in.nextInt();
                y[i] = in.nextInt();
            }
            System.out.println("Scenario #"+k);
            System.out.println("Frog Distance = " + String.format("%.3f", BF()));
            System.out.println();
            k++;
            n = in.nextInt();
        }
        
    }
}
