//rotate matrix
public class RotateImage {
	private int[][] m;
    public void rotate(int[][] matrix) {
        if(matrix == null) return;
        int n = matrix[0].length;
        this.m = matrix;
        solveRec(0, 0, n);
        
        return;
    }
    private void solveRec(int i, int j, int n){
        if(n == 1) return;
        if(n == 2) {
            int tmp = m[i][j];
            m[i][j] = m[i+1][j];
            m[i+1][j] = m[i+1][j+1];
            m[i+1][j+1] = m[i][j+1];
            m[i][j+1] = tmp;
            return;
        }
        int len = n-1;
        int[] temp = new int[len];
        for(int k = 0; k < len; k++){
            temp[k] = m[i][j+k];
            m[i][j+k] = m[i+len-k][j];
            m[i+len-k][j] = m[i+len][j+len-k];
            m[i+len][j+len-k] = m[i+k][j+len];
            m[i+k][j+len]=temp[k];
        }
        solveRec(i+1, j+1, n-2);
    }
    // a smarter way
    //先上下倒置，再左右翻转
    public void rotate2(int[][] matrix) {
        if(matrix == null) return;
        int n = matrix[0].length;
        for(int i = 0 ; i < n/2; i++){
            int[] tmp = matrix[i];
            matrix[i] = matrix[n-1-i];
            matrix[n-1-i] = tmp;
        }
        for(int j = 0; j < n; j++)
            for(int i = j+1; i<n; i++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        
        return;
    }
}
