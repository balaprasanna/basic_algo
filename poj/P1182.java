import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class P1182 {
    private static int N;
    private static int[] parent;
    private static int[] relation; //relation to parent
    private static int[] rank;
    private static Random rand;
    private static void init(){
      rand = new Random();
      parent = new int[N+1];
      relation = new int[N+1];
      rank = new int[N+1];
      for(int i = 1; i < parent.length; i++)
          parent[i] = i;
    }
    private static int findSet(int id){
        if(parent[id] != id){
            int tmp = parent[id];
            parent[id] = findSet(parent[id]);
            if(tmp != parent[id])
                relation[id] = (relation[tmp]+relation[id])%3;
        }
        return parent[id];
    }
    private static void union(int x, int y, int rel){
        int rootX = findSet(x);
        int rootY = findSet(y);
        //if(rank[x]<=rank[y]){
        if(rand.nextInt(2)== 0){
            parent[rootX] = rootY;
            relation[rootX] = (rel + 3 - relation[x] + relation[y])%3;
            if(rank[x] == rank[y])
                rank[x]++;
        }else{
            parent[rootY] = rootX;
            relation[rootY] = (relation[x] + 6-relation[y]-rel)%3;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] tm = read.readLine().split(" ");
        N = new Integer(tm[0]);
        int k = new Integer(tm[1]);
        init();
        
        int num = 0;
        int type = 0, x = 0, y = 0;
        while(k-->0){
            String[] tmp = read.readLine().split(" ");
            type = new Integer(tmp[0]);
            x = new Integer(tmp[1]);
            y = new Integer(tmp[2]);
            if(x > N || y > N ||(type == 2 && x == y)){
                num++;
                continue;
            }
            int rx = findSet(x);
            int ry = findSet(y);
            if(rx == ry){
                if(type == 1){
                    if(relation[x] != relation[y])
                        num++;
                }
                else{
                    if((relation[x]+3 -relation[y])%3 != 1 )
                        num++;
                }
            }else
                union(x, y , type-1);
        }
        System.out.println(num);
    }
}