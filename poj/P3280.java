import java.io.*;
import java.util.*;
class CharCost{
    int add,del;
    public CharCost(int a, int d){
        this.add = a;
        this.del = d;
    }
}
public class P3280{
    private static int N,M;
    private static int[][] cost;
    private static char[] arr;
    private static Hashtable<Character, CharCost> alp;
    
    private static int solve(int i, int j){
        if(i>j)
            return Integer.MAX_VALUE;
        if(cost[i][j] != Integer.MAX_VALUE)
            return cost[i][j];
        if(i == j)
            return cost[i][j] = 0;
        if(i+1 ==j && arr[i] == arr[j])
            return cost[i][j] = 0;
        int tmp = Integer.MAX_VALUE;
        //transfer from (i,j-1)
        tmp = Math.min(tmp, Math.min(alp.get(arr[j]).add, alp.get(arr[j]).del)+solve(i,j-1));
        //transfer from(i+1,j)
        tmp = Math.min(tmp, Math.min(alp.get(arr[i]).add, alp.get(arr[i]).del)+solve(i+1,j));
        //transfer form(i-1,j-1)
        if(arr[i] == arr[j])
            tmp = Math.min(tmp, solve(i+1,j-1));
        return cost[i][j] = tmp;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        N = in.nextInt();//alphabet
        M = in.nextInt();//length
        in.nextLine();
        cost = new int[M][M];
        for(int i = 0; i < M; i++)
            for(int j = 0; j < M; j++)
                cost[i][j] = Integer.MAX_VALUE;
        arr = in.nextLine().toCharArray();
        alp = new Hashtable<Character, CharCost>();
        String[] tmp;
        for(int i = 0; i < N; i++){
            tmp = in.nextLine().split(" ");
            alp.put(tmp[0].charAt(0), 
                    new CharCost(Integer.valueOf(tmp[1]), Integer.valueOf(tmp[2])));
        }
        solve(0,M-1);
        System.out.println(cost[0][M-1]);
    }
}