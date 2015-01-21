import java.io.*;
import java.util.*;

public class P1860 {
    private static int N;
    private static int M;
    private static int S;
    private static double V;
    private static double[] money;
    private static List<MyEdge> edgeList;
    public class MyEdge
    {
        private int from;
        private int to;
        private double comm;
        private double rate;

        public MyEdge(int i, int j, double aRate, double aComm)
        {
            from = i;
            to = j;
            comm = aComm;
            rate = aRate;
        }
    }
    private static void init(){
        money = new double[N+1];
        money[S] = V;
        edgeList = new ArrayList<MyEdge>();
    }
    private static boolean BellmanFord(){
        for(int k = 1; k<=N-1; k++){
            for(MyEdge myEdge: edgeList){
                if(money[myEdge.to] < (money[myEdge.from]-myEdge.comm)*myEdge.rate)
                    money[myEdge.to] = (money[myEdge.from]-myEdge.comm)*myEdge.rate;
            }
            if(money[S] > V)
                return true;
        }
        for(MyEdge myEdge: edgeList)
            if(money[myEdge.to] < (money[myEdge.from]-myEdge.comm)*myEdge.rate)
                return true;
        return false;
    }
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        Scanner in=new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        S = in.nextInt();
        V = in.nextDouble();
        init();
        for(int k = 0; k < M; k++){
            int i = in.nextInt();
            int j = in.nextInt();
            //edgeList.add(m.new MyEdge(i,j,in.nextDouble(),in.nextDouble()));
            //edgeList.add(m.new MyEdge(j,i,in.nextDouble(),in.nextDouble()));
        }
        if(BellmanFord())
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}