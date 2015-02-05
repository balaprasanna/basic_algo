import java.io.*;
import java.util.*;

public class P3050 {
    private static Hashtable<Integer, Integer> htable = new Hashtable<Integer,Integer>();
    private static int[][] map = new int[5][5];
    private static int[] ar = new int[6];
    private static int[] di = {-1,1,0,0};
    private static int[] dj = {0,0,1,-1};
    private static void DFS(int i, int j, int level){
        if(level == 6){
            int tmp = 0;
            for(int k = 0; k < 6; k++)
                tmp = tmp *10+ar[k];
            if(!htable.containsKey(tmp))
                htable.put(tmp, 0);
            return;
        }else{
            for(int k = 0; k < 4; k++){
                int ni = i + di[k];
                int nj = j + dj[k];
                if(ni >= 0 && ni < 5 && nj >=0 && nj <5){
                    ar[level] = map[ni][nj];
                    DFS(ni, nj, level+1);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        for(int i = 0 ; i < 5; i++)
            for(int j =0; j < 5; j++)
                map[i][j] = in.nextInt();
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++){
                ar[0] = map[i][j];
                DFS(i,j,1);
            }
        System.out.println(htable.size());
    }
}
