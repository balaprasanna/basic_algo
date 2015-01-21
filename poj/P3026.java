
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class P3026 {
    private static int ni, nj;
    private static int numA;
    private static int[][] ma;
    private static boolean[] visited;
    private static boolean[][] vm;
    private static int[] weight;
    private static List<Integer> apos;
    private static void init(){
        ma = new int[ni][nj];
        apos = new ArrayList<Integer>();
        numA = 1;
    }
    private static void alienInit(){
        visited = new boolean[numA];
        weight = new int[numA];
        for(int i = 0; i < numA; i++)
            weight[i] = Integer.MAX_VALUE;
    }
    private static void BFS(int i, int j){
        Queue<Integer> queue = new LinkedList<Integer>();
        vm = new boolean[ni][nj];
        queue.add(i*nj+j);
        int len = 1;
        int ctr = 1;
        int ictr = 0;
        while(ctr -- >0){
            int curA = queue.poll();
            int curi = curA/nj;
            int curj = curA%nj;
            if(!vm[curi][curj]){
                if(curi>0 && ma[curi-1][curj] >=0 && !vm[curi-1][curj]){
                    if(ma[curi-1][curj] != 0 && !visited[ma[curi-1][curj]-1]){
                        if(weight[ma[curi-1][curj]-1] > len)
                            weight[ma[curi-1][curj]-1] = len;
                    }
                    queue.add((curi-1)*nj+curj);
                    ictr++;
                }
                if(curi <ni-1 && ma[curi+1][curj] >=0 && !vm[curi+1][curj]){
                    if(ma[curi+1][curj] != 0 && !visited[ma[curi+1][curj]-1]){
                        if(weight[ma[curi+1][curj]-1] > len)
                            weight[ma[curi+1][curj]-1] = len;
                    }
                    queue.add((curi+1)*nj+curj);
                    ictr++;
                }
                if(curj > 0 && ma[curi][curj-1] >=0 && !vm[curi][curj-1]){
                    if(ma[curi][curj-1] != 0 && !visited[ma[curi][curj-1]-1]){
                        if(weight[ma[curi][curj-1]-1] > len)
                            weight[ma[curi][curj-1]-1] = len;
                    }
                    queue.add(curi*nj+curj-1);
                    ictr++;
                }
                if(curj < nj -1 && ma[curi][curj+1] >=0 && !vm[curi][curj+1]){
                    if(ma[curi][curj+1] != 0 && !visited[ma[curi][curj+1]-1]){
                        if(weight[ma[curi][curj+1]-1] > len)
                            weight[ma[curi][curj+1]-1] = len;
                    }
                    queue.add(curi*nj+curj+1);
                    ictr++;
                }
                vm[curi][curj] = true;
            }
            if(ctr == 0){
                ctr = ictr;
                ictr = 0;
                len++;
            }
        }       
    }
    private static int primMST(){
        int total = 0;
        visited[0] = true;
        int newNode = 0;
        for(int k = 1; k <numA; k++){
            int min = Integer.MAX_VALUE;
            int sj = apos.get(newNode)%nj;
            int si = apos.get(newNode)/nj;
            BFS(si,sj);
            for(int i = 0; i < numA; i++)
                if(!visited[i] && weight[i] < min){
                    min = weight[i];
                    newNode = i;
                }
            visited[newNode] = true;
            total += min;
        }
        return total;
    }
    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(System.in);
        int test = new Integer(in.nextLine());
        for(int k = 0; k < test; k++){
            String[] t = in.nextLine().split(" ");
            nj = new Integer(t[0]);
            ni = new Integer(t[1]);
            init();
            
            for(int i = 0 ; i < ni; i++){
                String tmp = in.nextLine();
                if(i == 0 || i == ni-1){
                    for(int j = 0; j < nj; j++)
                        ma[i][j] = -1; //block
                }else{
                    for(int j = 0; j < nj; j++){
                        if(tmp.charAt(j) == '#')
                            ma[i][j] = -1; //block
                        else if (tmp.charAt(j) == 'A'){
                            ma[i][j] = ++numA; //alien number
                            apos.add(i*nj+j);
                        }
                        else if(tmp.charAt(j) == 'S'){
                            ma[i][j] = 1; //startpoint
                            apos.add(0, i*nj+j);
                        }
                        else
                            ma[i][j] = 0; //space
                    }
                }
            }
            alienInit();   
            System.out.println(primMST());
        }
    }
}