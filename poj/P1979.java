import java.io.*;
import java.util.*;

public class P1979 {
    private static int W,H;
    private static boolean[][] visited;
    private static boolean[][] tiles;
    //private static int[] di = {-1, 0,0,1};
    //private static int[] dj = {0,-1,1,0};
    private static int DFS(int pi, int pj){
        int ctr = 1;
        visited[pi][pj] = true;
        if(pi > 0 && tiles[pi -1][pj] && !visited[pi-1][pj])
            ctr += DFS(pi-1, pj);
        if(pi <H-1 && tiles[pi +1][pj] && !visited[pi+1][pj])
            ctr += DFS(pi+1, pj);
        if(pj > 0 && tiles[pi][pj-1] && !visited[pi][pj-1])
            ctr += DFS(pi, pj-1);
        if(pj <W-1 && tiles[pi][pj+1] && !visited[pi][pj+1])
            ctr += DFS(pi, pj+1);
        return ctr;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] tm = read.readLine().split(" ");
        W = Integer.valueOf(tm[0]);
        H = Integer.valueOf(tm[1]);
        String tmp = null;
        char t = 'a';
        int pi=0,pj=0;
        while(W*H != 0){
            tiles = new boolean[H][W];
            visited = new boolean[H][W];
            for(int i = 0; i < H; i++){
                tmp = read.readLine();
                for(int j = 0; j < W; j++){
                    t = tmp.charAt(j);
                    if(t == '.')
                        tiles[i][j] = true;
                    else if (t == '@'){
                        tiles[i][j] = true;
                        pi = i;
                        pj = j;
                    }
                }
            }
            System.out.println(DFS(pi, pj));
            tm = read.readLine().split(" ");
            W = Integer.valueOf(tm[0]);
            H = Integer.valueOf(tm[1]);
        }
    }
}
