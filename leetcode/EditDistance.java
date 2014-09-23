//DP
//need to review
public class EditDistance {
	public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dist = new int[n1+1][n2+1];
        //i = 0; word1 = ""
        //have to insert everthing
        for(int j = 0; j < n2 + 1; j++) dist[0][j] = j;
        //j = 0; word2 = ""
        //have to delete everything
        for(int i = 0; i < n1+1; i++) dist[i][0] = i;
        for(int i = 1; i < n1+1; i++)
            for(int j = 1; j < n2+1; j++){
                int del = dist[i-1][j]+1;
                int ins = dist[i][j-1]+1;
                int replace = dist[i-1][j-1];
                if(word1.charAt(i-1) != word2.charAt(j-1))
                    replace++;
                dist[i][j] = Math.min(Math.min(del, ins), replace);
                
            }
        return dist[n1][n2];
    }
}
