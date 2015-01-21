import java.io.*;
import java.util.*;

public class P3617 {
    private static int n;
    private static char[] init;
    private static char[] ni;
    private static int ctr;
    private static void move(int p, int step, int d){
            for(int i = 0; i < step; i++)
                ni[ctr++] = init[p+i*d];
    }
    
    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(System.in);
        n = in.nextInt();
        init = new char[n];
        ni = new char[n];
        in.nextLine();
        for(int i = 0; i < n; i++){
            init[i] = in.nextLine().charAt(0);
        }
        int i = 0, j = n-1;
        while(i<=j){
            if(init[i] < init[j]){
                move(i,1,1);
                i++;
            }else if(init[i] > init[j]){
                move(j,1,-1);
                j--;
            }else {
                int p = i+1, q= j-1;
                while(p<q){
                    if(init[p]<init[q]){
                        move(i,1,1);
                        i++;
                        break;
                    }else if(init[p] > init[q] || init[p]>init[i]){
                        move(j,1,-1);
                        j--;
                        break;
                    }
                    p++;
                    q--;
                }
                if(p>=q){
                    move(i++,1,1);
                }
            }
        }
        String s = new String(ni);
        while(s.length()>80){
            System.out.println(s.substring(0, 80));
            s = s.substring(80, s.length());
        }
        System.out.println(s);
    }
}
