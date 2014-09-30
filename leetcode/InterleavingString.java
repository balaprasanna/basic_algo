//纯recursive的方法，TLE
//DP的方法，会减少很多冗余？
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()) return false;
        int m = s1.length();
        int n = s2.length();
        boolean[][] b = new boolean[m+1][n+1];
        b[0][0] = true;
        for(int i = 0; i <= m; i++)
            for(int j = 0; j <= n; j++){
                if(j > 0)
                    b[i][j] = b[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1);
                if(i > 0)
                    b[i][j] = b[i][j] || (b[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
            }
        
        return b[m][n];
    }
}
