import java.io.*;
import java.util.*;

public class P2386 {
    private static int n;
    private static int m;
    private static int[][] ma; //0 is dry land, 1 is water
    private static int[] dx = {-1,-1,-1,0,0,1,1,1};
    private static int[] dy = {-1,0,1,-1,1,-1,0,1};
    private static void DFS(int p, int q){
        Stack<Integer> stack = new Stack<Integer>();
        ma[p][q] = 0;
        stack.push(p*m+q);
        //8 position
        int x,y;
        while(!stack.isEmpty()){
            int t = stack.pop();
            x = t/m;
            y = t%m;
            for(int i = 0; i <= 7; i++){
                if(x+dx[i]>=0 && x+dx[i]<n && y+dy[i]>=0 && y+dy[i]<m 
                        && ma[x+dx[i]][y+dy[i]] == 1){
                    ma[x+dx[i]][y+dy[i]] = 0;
                    stack.push((x+dx[i])*m+y+dy[i]);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        ma = new int[n][m];
        //read in data
        in.nextLine();
        for(int i = 0; i < n; i++){
            String tmp = in.nextLine();
            for(int j = 0; j < m; j++)
                if(tmp.charAt(j) == 'W')
                    ma[i][j] = 1;
        }
        int ctr = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++){
                if(ma[i][j] == 1){
                    ctr++;
                    DFS(i,j);
                }
            }
        System.out.println(ctr);
    }
}
