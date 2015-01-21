import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class P2485 {
    private static int n;
    private static int[][] ma;
    private static boolean[] visited;
    private static void init(){
        ma = new int[n][n];
        visited = new boolean[n];
    }
    private static int primMST(){
        int max = 0;
        visited[0] = true;
        for(int k = 1; k <n; k++){
            int min = Integer.MAX_VALUE;
            int newNode = n;
            for(int i = 0; i < n; i++)
                if(!visited[i] && ma[0][i] < min){
                    min = ma[0][i];
                    newNode = i;
                }
            visited[newNode] = true;
            if(min > max)
                max = min;
            for(int i = 0; i < n; i++)
                if(!visited[i] && ma[0][i] > ma[newNode][i])
                    ma[0][i] = ma[newNode][i];
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(System.in); 
        int testNum = in.nextInt();
        while(testNum-- > 0){
            n = in.nextInt();
            init();
            String[] tmp = null;
            for(int i = 0 ; i < n; i++)
                for(int j = 0; j < n; j++)
                    ma[i][j] = in.nextInt();
            System.out.println(primMST());
        }
    }
}