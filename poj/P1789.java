import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class P1789 {
    private static int n;
    private static String[] code;
    private static int[][] distMatrix;
    private static boolean[] visited;
    
    private static void init(){
        code = new String[n];
        visited = new boolean[n];
        distMatrix = new int[n][n];
    }
    private static void distInit(){
        String a = null;
        String b = null;
        for(int i = 0; i < n; i++){
            distMatrix[i][i] = 8;
            for(int j = i+1; j < n; j++)
            {
                a = code[i];
                b = code[j];
                for(int k = 0; k < 7; k++)
                    if(a.charAt(k)!=b.charAt(k))
                        distMatrix[i][j]++;
                distMatrix[j][i] = distMatrix[i][j];        
            }
        }
    }
    private static int primMST(){
        distInit();
        int total = 0;
        Random rand = new Random();
        int cur = rand.nextInt(n);
        visited[cur] = true;
        int k = 1;
        while(k++ <n){
            int min = 8;
            int newNode = n;
            for(int i = 0; i < n; i++)
                if(!visited[i] && min > distMatrix[cur][i]){
                    min = distMatrix[cur][i];
                    newNode = i;
                }
            visited[newNode] = true;
            total += min;
            
            for(int i = 0; i < n; i++)
                if(!visited[i] && distMatrix[newNode][i] < distMatrix[cur][i])
                    distMatrix[cur][i] = distMatrix[newNode][i];
        }
        return total;
    }
    
    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(System.in); 
        while(true){
            n = in.nextInt();
            if(n == 0) break;
            init();
            for(int k = 0 ; k < n; k++)
                code[k] = in.next();
            System.out.println("The highest possible quality is 1/"+primMST()+".");
        }
    }
}