import java.io.*;
import java.util.*;

public class P2376 {
    public static void main(String[] args) throws Exception {
        Main m = new Main();
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); //number of cows
        int T = in.nextInt(); //number of shifts
        int[] shifts = new int[T+1]; //using index starting from 1 to T
        for(int i = 0; i < T; i++)
            shifts[T] = -1;
        int start, end;
        for(int i = 0; i < N; i++){
            start = in.nextInt();
            end = in.nextInt();
            shifts[start] = Math.max(shifts[start], end);
        }
        int ctr = 0;
        int l = 1,r = 1;
        int max = 0;
        while(max < T){
            int nmax = 0;
            for(int i = l; i <=r; i++)
                if(shifts[i]!=-1)
                    nmax = Math.max(nmax, shifts[i]);
            if(nmax > max){
                ctr++;
                l = r+1;
                r = nmax+1;
                
            }else{
                System.out.println(-1);
                return;
            }
            max = nmax;
        }
        System.out.println(ctr);
    }
}
