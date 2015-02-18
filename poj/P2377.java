import java.util.Scanner;

public class P2377 {
    private static int N,M;
	private static int[][] roads;

	private static int solve(){
		int[] max = new int[N+1];
		boolean[] used = new boolean[N+1];
		for(int i = 1; i <= N; i++)
			max[i] = Integer.MIN_VALUE;
		int cur = 1;
		used[cur] = true;
		max[cur] = 0;
		for(int i = 1; i < N; i++){
			int next = 0;
			int curMax = 0;
			for(int j = 1; j <= N; j++){
				if(!used[j] && roads[cur][j] != 0)
					max[j] = Math.max(max[j], roads[cur][j]);
				if(!used[j] && max[j] > curMax){
					next = j;
					curMax = max[j];
				}
			}
			cur = next;
			if(cur != 0)
				used[cur] = true;
			else
				break;
		}
		for(int i = 1; i <= N; i++)
			if(!used[i])
				return -1;
		int ret = 0;
		for(int i = 1; i <= N; i++)
			ret += max[i];
		return ret;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        N = in.nextInt();//farms
		M = in.nextInt();//roads
		roads = new int[N+1][N+1];
		int x,y,c;
		for(int i = 0; i < M; i++){
			//pay attention to duplicate edges
			x = in.nextInt();
			y = in.nextInt();
			c = in.nextInt();
			roads[x][y] = Math.max(roads[x][y], c);
			roads[y][x] = roads[x][y];
		}
		System.out.println(solve());
    }
}
