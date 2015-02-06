import java.io.*;
import java.util.*;

public class P2393 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //number of weeks
        int s = in.nextInt(); //cost of storage
        int[] c = new int[n]; //cost of weekly production
        int[] y = new int[n]; //number of delivery
        for(int i = 0; i < n; i++){
            c[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        if(n == 0){
            System.out.println(0);
            return;
        }
        int minCost = c[0];
        long money = minCost*y[0];
        for(int i = 1; i < n; i++){
            minCost = Math.min(c[i], minCost+s);
            money += minCost*y[i];
        }
        System.out.println(money);
    }
}
