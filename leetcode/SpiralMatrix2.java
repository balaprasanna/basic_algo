
public class SpiralMatrix2 {
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
        if(n <= 0) return matrix;
		
		int start = 0;
        int finish = n-1;
        int ctr= 1;
        while(start < finish){
            int x = start, y = start;
            while(y < finish)  matrix[x][y++] = ctr++;
            while(x < finish) matrix[x++][y] = ctr++;
            while(y > start) matrix[x][y--] = ctr++;
            while(x > start) matrix[x--][y] =ctr++;
            start ++; finish--;
        }
        if(start == finish) 
        	matrix[start][start] =ctr;
        return matrix;    
    }
}
