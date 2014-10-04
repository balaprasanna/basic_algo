//DP
//有点绕，再好好研究下
public class PalindromePartition2 {
	public int minCut(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        boolean[][] pan = new boolean[n][n];
        int[] cut = new int[n];
        for(int i = n-1; i >=0; i--){
            cut[i] = n-i-1; 
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j) && (j-i<2 || pan[i+1][j-1]))
                {    
                    pan[i][j] = true;
                    if(j == n-1)
                        cut[i] = 0;
                    else if(cut[j+1]+1<cut[i])
                        cut[i] = cut[j+1]+1;
                }
            }
        }
        return cut[0];
    }
}
