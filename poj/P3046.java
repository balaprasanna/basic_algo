import java.io.*;
import java.util.*;
public class P3046{
    private static int T,A,S,B;
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        T = in.nextInt();
        A = in.nextInt();
        S = in.nextInt();
        B = in.nextInt();
        int[] ants = new int[T];
        for(int i = 0; i < A; i++)
            ants[in.nextInt()-1]++;
        int[] oldC = new int[B+1];
        int[] newC;
        for(int i = 0; i < T; i++){
            newC = new int[B+1];
            for(int j = 1; j <= ants[i] && j<=B; j++)
                newC[j] = 1;
            for(int j = 0; j<=ants[i]; j++)
                for(int k = B; k-j>0; k--)
                        newC[k] += oldC[k-j]%1000000;
            oldC = newC;
        }
        int ctr =0;
        for(int i = S; i<=B; i++)
            ctr += oldC[i] % 1000000;
        System.out.println(ctr%1000000);
    }
}