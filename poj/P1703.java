import java.io.*;
import java.util.*;

public class P1703{
    private static int[] par;
    private static int[] samegang; //0 same, 1 different
    private static Random rd = new Random();
    private static int findRoot(int a){
        if(par[a] == a)
            return a;
        else{
            int rt = findRoot(par[a]);
            samegang[a] = (samegang[a]+samegang[par[a]])%2;
            return par[a] = rt;
        }
    }
    private static void connect(int a, int b){
        int ra = findRoot(a);
        int rb = findRoot(b);
        if(ra == rb)
            return;
        if(rd.nextInt(2) == 1){
            par[ra] = rb;
            if(samegang[a] == samegang[b])
                samegang[ra] = 1;
            else
                samegang[ra] = 0;
        }   
        else{
            par[rb] =ra;
            if(samegang[a] == samegang[b])
                samegang[rb] = 1;
            else
                samegang[rb] = 0;
        }
    }
    private static void connected(int a, int b){
        if(findRoot(a) == findRoot(b)){
            if(samegang[a] == samegang[b])
                System.out.println("In the same gang.");
            else
                System.out.println("In different gangs.");
        }else
            System.out.println("Not sure yet.");
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in)); 
        //Scanner in=new Scanner(System.in);
        int T = Integer.parseInt(buf.readLine());
        while(T-->0){
            String str[] = buf.readLine().split(" ");  
            int N = Integer.parseInt(str[0]);  
            int M = Integer.parseInt(str[1]);  
            
            par = new int[N+1]; //start from 1
            samegang = new int[N+1];
            for(int i = 1; i <= N; i++)
                par[i] = i;
            for(int i = 0; i < M; i++){
                str = buf.readLine().split(" ");  
                int x = Integer.parseInt(str[1]);  
                int y = Integer.parseInt(str[2]);  
                if(str[0].equals("A")){
                    if(N == 2)  
                        System.out.println("In different gangs.");
                    else
                        connected(x, y);
                }else
                    connect(x, y);
            }
        }
        
    }
}