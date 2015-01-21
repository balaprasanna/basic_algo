import java.io.*;
import java.util.*;

public class P3984 {
    private static int[][] ma;
    private static int[][] pre;
    private static int[] dx = {-1,0,0,1};
    private static int[] dy = {0,-1,1,0};
    private static void BFS(){
        Queue<Integer> que = new LinkedList<Integer>();
        que.add(0);
        pre[0][0] = 0;
        int x,y;
        while(!que.isEmpty() && pre[4][4]==Integer.MAX_VALUE){
            x = que.peek()/5;
            y = que.poll()%5;
            for(int i = 0; i<4; i++)
                    if(x+dx[i]>=0 && x+dx[i]<5 && y+dy[i]>=0 && y+dy[i]<5 
                            && pre[x+dx[i]][y+dy[i]] == Integer.MAX_VALUE 
                            && ma[x+dx[i]][y+dy[i]] == 0){
                        pre[x+dx[i]][y+dy[i]] = x*5+y;
                        que.add((x+dx[i])*5+y+dy[i]);
                }
        }
    }
    
    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(System.in);
        ma = new int[5][5];
        pre = new int[5][5];
        
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++){
                ma[i][j] = in.nextInt();
                pre[i][j] = Integer.MAX_VALUE;
            }
        BFS();
        Stack<Integer> stack = new Stack<Integer>();
        int cur = 24;
        while(cur != 0){
            stack.push(cur);
            cur = pre[cur/5][cur%5];
        }
        stack.push(0);
        while(!stack.isEmpty()){
            cur = stack.pop();
            System.out.println("("+cur/5+", "+cur%5+")");
        }

    }
}
