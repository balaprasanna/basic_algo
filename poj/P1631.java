import java.io.*;
import java.util.*;

public class P1631{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int T = in.nextInt();
        while(T-->0){
            int p = in.nextInt();
            int[] pair = new int[p+1];
            for(int i = 1; i <=p; i++)
                pair[i] = in.nextInt();
            int[] inc = new int[p+1];
            int len = 1;
            inc[1] = pair[1];
            int pos = 0;
            for(int i = 2; i<=p; i++){
                pos = -Arrays.binarySearch(inc, 1, len+1, pair[i])-1;
                if(pos <= len)
                    inc[pos] = pair[i];
                else
                    inc[++len] = pair[i];
            }
            System.out.println(len);
        }
    }
}