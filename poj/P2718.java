import java.io.*;
import java.util.*;

public class P2718 {
    private static int[] digits;
    private static boolean[] used;
    private static int[] ar;
    private static int dif;
    private static int l;
    private static void DFS(int level){
        if(level == digits.length){
            //all arrangements down
            int left = 0, right = 0;
            for(int i = 0; i < l; i++)
                left = left*10+ar[i];
            for(int i = l; i < digits.length; i++)
                right = right*10+ar[i];
            dif = Math.min(dif, Math.abs(left-right));
            return;
        }else{
            for(int i = 0; i < digits.length; i++){
                if(!used[i] && ((level != 0 && level != l) || digits[i]!= 0)){
                    used[i] = true;
                    ar[level] = digits[i];
                    DFS(level+1);
                    used[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.nextLine();//not sure
        while(num -- > 0){
            String[] tmp = in.nextLine().split(" ");
            digits = new int[tmp.length];
            used = new boolean[tmp.length];
            dif = Integer.MAX_VALUE;
            ar = new int[tmp.length];
            l = digits.length/2;
            //r = digits.length - l;
            for(int i = 0; i < tmp.length; i++)
                digits[i] = Integer.valueOf(tmp[i]);
            if(digits.length == 2)
                dif = Math.abs(digits[0] - digits[1]);
            else
                DFS(0);
            System.out.println(dif);
        }

    }
}
