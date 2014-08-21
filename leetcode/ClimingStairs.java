//leetcode DP
//easy fibbonacci
public class ClimingStairs {
	public int climbStairsSolution(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] ways = new int[n+1];
        for (int i = 2; i < n+1; i++)
            ways[i] = Integer.MAX_VALUE;
        ways[1] = 1;
        ways[2] = 2;
        for (int i = 3; i < n+1; i++)
            ways[i] = ways[i-1]+ways[i-2];
        return ways[n];
    }
}
