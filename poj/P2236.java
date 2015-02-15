import java.io.*;
import java.util.*;

class Computer {
    int x,y;
    public Computer(int x, int y){
        this.x = x;
        this.y = y;
    }
    public boolean reachable(Computer o, int D){
        boolean ret = (this.x-o.x)*(this.x-o.x) + (this.y - o.y)*(this.y - o.y) <= D*D;
        //System.out.println(ret);
        return ret;
    }
}

public class P2236{
    private static int N; //number of computers
    private static int D; //max distance
    private static Computer[] cs;
    private static int[] par;
    private static Random rd = new Random();
    
    private static int findRoot(int a){
        if(par[a] == a)
            return a;
        else
            return par[a] = findRoot(par[a]);
    }
    private static void connect(int a, int b){
        int ra = findRoot(a);
        int rb = findRoot(b);
        if(ra == rb)
            return;
        if(rd.nextInt(2) == 0)
            par[ra] = rb;
        else
            par[rb] =ra;
    }
    private static boolean connected(int a, int b){
        if(par[a] == 0||par[b] == 0)
            return false;
        return findRoot(a) == findRoot(b);
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        N = in.nextInt();
        D = in.nextInt();
        cs = new Computer[N+1];
        for(int i = 1; i <= N; i++)
            cs[i] = new Computer(in.nextInt(), in.nextInt());
        in.nextLine();
        par = new int[N+1];
        while(in.hasNextLine()){
            String[] tmp = in.nextLine().split(" ");
            
            if(tmp[0].equals("O")){
              //repairing the computer
                int c = Integer.valueOf(tmp[1]);
                par[c] = c;
                for(int i = 1; i <= N; i++)
                    if(i != c && par[i] != 0 && cs[c].reachable(cs[i], D))
                        connect(c, i);
            }else{
              //test connection
                int a = Integer.valueOf(tmp[1]);
                int b = Integer.valueOf(tmp[2]);
                if(connected(a, b))
                    System.out.println("SUCCESS");
                else
                    System.out.println("FAIL");
            }
        }
    }
}