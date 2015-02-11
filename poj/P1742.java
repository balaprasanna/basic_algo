import java.io.*;
import java.util.*;
//传说中的男人8题，看着像多重背包问题的计数问题
public class P1742{
    private static int n,m;
    private static int[] values, numbers;
    private static boolean[] ret;
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        while(n*m != 0){
            values = new int[n];
            numbers = new int[n];
            for(int i =0; i < n; i++)
                values[i] = in.nextInt();
            for(int i =0; i < n; i++)
                numbers[i] = in.nextInt();
            ret = new boolean[m+1];
            for(int i = 0; i < n; i++){
                int v = values[i];
                for(int j = m; j>=0; j--)
                    if(ret[j]||j==0){
                        for(int k = 1; k <= numbers[i]; k++){
                            //这里有一个剪枝，如果遇到已经可行的值，就跳出
                            //因为V是从大到小循环的，后面要处理的值会已经被处理了
                            if(j+k*v>m || ret[j+k*v])
                                break;
                            ret[j+k*v] = true;
                        }
                    }
            }
            int ctr = 0;
            for(int i = 1; i <= m; i++)
                if(ret[i])
                    ctr++;
            System.out.println(ctr);
            n = in.nextInt();
            m = in.nextInt();
        }
    }
}