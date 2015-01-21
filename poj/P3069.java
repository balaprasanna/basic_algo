import java.io.*;
import java.util.*;

public class P3069 {
    private static int r;
    private static int n;
    private static int[] pos;
    private static int count(){
        Arrays.sort(pos);
        int left = pos[0];
        int ctr = 0;
        boolean flag = true;
        for(int i = 0; i < n; i++){
            if(flag){
                if(pos[i] <= left + r)
                    continue;
                else{
                    ctr++;
                    left = pos[i-1];
                    i=i-2;
                    flag = false;
                    continue;
                }
            }
            if(!flag){
                if(pos[i] <= left+r)
                    continue;
                else{
                    left = pos[i];
                    i--;
                    flag = true;
                    continue;
                }
            }
        }
        if(flag)
            return ctr+1;
        return ctr;
        
    }
    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(System.in);
        r = in.nextInt();
        n = in.nextInt();
        while(!(r == -1 && n == -1)){
            pos = new int[n];
            for(int i = 0; i < n; i++)
                pos[i] = in.nextInt();
            System.out.println(count());
            r = in.nextInt();
            n = in.nextInt();
        }
    }
}
