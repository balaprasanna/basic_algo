//leetcode 2D DP
public class UniqueBST {
	 public static int numTrees(int n) {
	        if (n == 1) return 1;
	        if (n == 2) return 2;
	        int[][] num = new int[n+1][n+1];
	        for (int len = 1; len <=n; len++){
	            if (len == 1)
	                for (int i = 1; i <= n; i++)
	                    num[i][i] = 1;
	            else if (len ==2)
	                for (int i = 1; i<=n-1; i++)
	                    num[i][i+1] = 2;
	            else
	                for (int i = 1; i <= n+1-len; i++){
	                    for (int j = i+1; j < i+len-1; j++)
	                        num[i][i+len-1] += num[i][j-1]*num[j+1][i+len-1];
	                    num[i][i+len-1] += num[i+1][i+len-1];
	                    num[i][i+len-1] += num[i][i+len-2];
	                }
	        }
	        return num[1][n];
	    }
	 public static void main(String[] args){
		 int n = 3;
		 System.out.print(numTrees(n));
	 }
}
