import java.util.Scanner;

public class P2139 {
	private static int N,M;
	private static int[][] dist;
	private static void floyd(){
		for(int k = 1; k <= N; k++)
			for(int i =1 ;i <= N; i++)
				for(int j = 1; j <=N; j++)
					dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);

	}
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        N = in.nextInt();
		M = in.nextInt();
		dist= new int[N+1][N+1];
		for(int i = 1; i <= N; i++)
			for(int j = 1; j <= N; j++)
				if(i == j)
					dist[i][j] = 0;
				else
					dist[i][j] = Integer.MAX_VALUE/10;
		in.nextLine();
		for(int k = 0; k < M; k++){
			String[] tmp = in.nextLine().split(" ");
			int size = Integer.parseInt(tmp[0]);
			int[] index = new int[size];
			for(int i = 0; i < size; i++)
				index[i] = Integer.parseInt(tmp[i+1]);
			for(int p = 0; p < size; p++)
				for(int q = p+1; q < size; q++){
					dist[index[p]][index[q]] = 1;
					dist[index[q]][index[p]] = 1;
				}
		}
		floyd();
		int ret = Integer.MAX_VALUE;
		for(int i = 1; i <= N; i++){
			int tmp = 0;
			for(int j = 1; j <= N; j++)
				if(i != j)
					tmp += dist[i][j];
			ret = Math.min(ret, tmp);
		}
		System.out.println(ret*100/(N-1));
    }
}
