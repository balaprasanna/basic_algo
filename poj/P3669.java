import java.io.*;
import java.util.*;

public class P3669 {
    private static int L = 400;
    private static int[][] map;
    private static int BFS(){
        if(map[0][0] == Integer.MAX_VALUE) return 0; //corner case
        if(map[0][0] == 0) return -1;
        int t = 1;
        boolean[][] visited = new boolean[L][L];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        visited[0][0] = true;
        int ctr, tmp,x,y;
        while(!queue.isEmpty()){
            ctr = queue.size();
            while(ctr-->0){
                tmp = queue.poll();
                x = tmp/L;
                y = tmp%L;
                //up
                if(x>0 && !visited[x-1][y]){
                    if(map[x-1][y] == Integer.MAX_VALUE) return t;
                    else if (map[x-1][y] > t){
                        visited[x-1][y] = true;
                        queue.add(L*(x-1)+y);
                    }
                }
                //down
                if(x<L-1 && !visited[x+1][y]){
                    if(map[x+1][y]==Integer.MAX_VALUE) return t;
                    else if (map[x+1][y] > t){
                        visited[x+1][y] = true;
                        queue.add(L*(x+1)+y);
                    }
                }
                //left
                if(y>0 && !visited[x][y-1]){
                    if(map[x][y-1] == Integer.MAX_VALUE) return t;
                    else if (map[x][y-1] > t){
                        visited[x][y-1] = true;
                        queue.add(L*x+y-1);
                    }
                }
                //right
                if(y<L-1 && !visited[x][y+1]){
                    if(map[x][y+1] == Integer.MAX_VALUE) return t;
                    else if (map[x][y+1] > t){
                        visited[x][y+1] = true;
                        queue.add(L*x+y+1);
                    }
                }
            }
            t++;
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        map = new int[L][L];
        for(int p = 0; p <L; p++)
            for(int q = 0; q < L; q++)
                map[p][q] = Integer.MAX_VALUE; //initialization
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int x,y,t;
        for(int i = 0; i < m; i++){
            x = in.nextInt();
            y = in.nextInt();
            t = in.nextInt();
            map[x][y] = Math.min(t, map[x][y]);
            if(x>0)map[x-1][y] = Math.min(t, map[x-1][y]);
            if(x<L-1) map[x+1][y] = Math.min(t, map[x+1][y]);
            if(y>0) map[x][y-1] = Math.min(t, map[x][y-1]);
            if(y<L-1) map[x][y+1] = Math.min(t, map[x][y+1]);
        }
        System.out.println(BFS());
    }
}
