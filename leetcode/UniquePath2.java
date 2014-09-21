
public class UniquePath2 {
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if(obstacleGrid[0][0] == 1) return 0;
        int[][] num = new int[m][n];
        num[0][0] = 1;
        boolean blocked = false;
        //process first row
        for(int j = 1; j <n; j++)
        {
            if(!blocked){
                if(obstacleGrid[0][j] == 1){
                    blocked = true;
                    num[0][j] = 0;
                }else
                    num[0][j] = 1;
            }else
                num[0][j] = 0;
        }
        //process first col
        blocked = false;
        for(int i = 1; i<m; i++){
            if(!blocked){
                if(obstacleGrid[i][0] == 1){
                    blocked = true;
                    num[i][0] = 0;
                }else
                    num[i][0] = 1;
            }else
                num[i][0] = 0;
        }
        
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
            {
                if(obstacleGrid[i][j] == 1)
                    num[i][j] = 0;
                else
                    num[i][j] = num[i][j-1]+num[i-1][j];
            }
        return num[m-1][n-1];
    }
	public static void main(String[] args){
		int[][] a = {{0,0},{1,0}};
		System.out.print(uniquePathsWithObstacles(a));
	}
}
