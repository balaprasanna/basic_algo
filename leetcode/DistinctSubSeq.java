//leetcode DP
//two-dimentional
public class DistinctSubSeq {
	public static int numDistinct(String S, String T) {
        int slen = S.length();
        int tlen = T.length();
        if (slen < tlen) return 0;
        if (slen == tlen){
            if (S.equals(T)) return 1;
            else return 0;
        }
        
        int[][] path = new int[tlen+1][slen+1];
        //init 
        for (int i = 0; i < slen+1; i++)
        	path[0][i] = 0;
            
        for (int i = 0; i < tlen+1; i++)
            path[i][0] = 0;
        
        for (int i = 1; i< tlen+1; i++)
            for (int j = 1; j < slen+1; j++){
                if (T.charAt(i-1) == S.charAt(j-1)){
                	if (i != 1)
                		path[i][j] = path[i][j-1] + path[i-1][j-1];
                	else
                		path[i][j] = path[i][j-1] + 1;
                }
                else
                    path[i][j] = path[i][j-1];
            }
        return path[tlen][slen];
    }
	public static void main(String[] args){
		String S="ccc";
		String T="c";
		System.out.print(numDistinct(S,T));
	}
}
