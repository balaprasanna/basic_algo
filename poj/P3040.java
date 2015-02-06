import java.io.*;
import java.util.*;
class Coin implements Comparable<Coin>{
    public int v,b;
    public Coin(int value, int number){
        this.v = value;
        this.b = number;
    }
    public int compareTo(Coin o){
        return -this.v + o.v;
    }
    
}
public class P3040 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Coin[] sets = new Coin[n];
        int c = in.nextInt(); // cost to pay every week
        for(int i = 0; i < n; i++)
            sets[i] = new Coin(in.nextInt(), in.nextInt());
        Arrays.sort(sets);
        int start = 0, end =n-1;
        int days = 0;
        while(start <= end && sets[start].v >= c){
            days += sets[start].b;
            sets[start].b = 0;
            start++;
        }
        if(start > end){
            System.out.println(days);
            return;
        }
        int cur = c;
        while(cur == c){
            cur = 0;
            if(start > end)
                break;
            for(int i = start; i <= end; i++){
                if(sets[i].b == 0)
                    continue;
                int num = (c-cur)/sets[i].v;
                if(num <= sets[i].b){
                    sets[i].b -= num;
                    cur += num*sets[i].v;
                    if(cur == c)
                        break;
                    if(i == end){
                        sets[i].b --;
                        cur = c;
                        break;
                    }
                    continue;
                }else{
                    cur += sets[i].v*sets[i].b;
                    sets[i].b = 0;
                }
            }
            if(cur == c)
                days++;
            else{
                for(int i = end; i>=start; i--){
                    if(sets[i].b == 0)
                        continue;
                    sets[i].b--;
                    if(sets[i].b >0)
                        end = i;
                    else
                        end = i-1;
                    cur = c;
                    days++;
                    break;
                }
            }
        }
        System.out.println(days);
    }
}
