import java.io.*;
import java.util.*;

public class P3009 {
    private static int W,H;
    private static int[][] map;
    
    private static int DFS(int si, int sj, int countdown){
        if(countdown == 0) return -1;
        int i = si, j = sj;
        int step = Integer.MAX_VALUE;
        //search up
        while(i>0 && map[i-1][j] == 0)
            i--;
        if(i != 0){
            if(map[i-1][j] == 3) return 1;
            else if(i != si && map[i-1][j] == 1){
                map[i-1][j] = 0;
                int ret = DFS(i,j,countdown-1);
                if(ret != -1)
                    step = Math.min(step, ret+1);
                map[i-1][j] = 1;
            } 
        }
        //search down
        i = si; j = sj;
        while(i<H-1 && map[i+1][j] == 0 )
            i++;
        if(i != H-1 ){
            if(map[i+1][j] == 3) return 1;
            if(i!= si && map[i+1][j] == 1){
                map[i+1][j] = 0;
                int ret = DFS(i,j,countdown-1);
                if(ret != -1)
                    step = Math.min(step, ret+1);
                map[i+1][j] = 1;
            } 
        }
        //search left
        i = si; j = sj;
        while(j>0 && map[i][j-1] == 0 )
            j--;
        if(j != 0 ){
            if(map[i][j-1] == 3) return 1;
            if(j != sj && map[i][j-1] == 1){
                map[i][j-1] = 0;
                int ret = DFS(i,j,countdown-1);
                if(ret != -1)
                    step = Math.min(step, ret+1);
                map[i][j-1] = 1;
            } 
        }
        //search right
        i = si; j = sj;
        while(j<W-1 && map[i][j+1] == 0 )
            j++;
        if(j != W-1){
            if(map[i][j+1] == 3) return 1;
            if(j!= sj && map[i][j+1] == 1){
                map[i][j+1] = 0;
                int ret = DFS(i,j,countdown-1);
                if(ret != -1)
                    step = Math.min(step, ret+1);
                map[i][j+1] = 1;
            } 
        }
        if(step == Integer.MAX_VALUE)
            return -1;
        return step;
    }
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        W = in.nextInt();
        H = in.nextInt();
        //starting position
        int si = 0;
        int sj = 0;
        while(W*H != 0){
            map = new int[H][W];
            for(int i = 0; i < H; i++)
                for(int j = 0; j < W; j++){
                    map[i][j] = in.nextInt();
                    if(map[i][j] == 2){
                        si = i;
                        sj = j;
                        map[i][j] = 0;
                    }
                }
            System.out.println(DFS(si,sj,10));
            W = in.nextInt();
            H = in.nextInt();
        }
    }
}
