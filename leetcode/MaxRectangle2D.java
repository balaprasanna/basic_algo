//use largest rectangle as subroutine
public class MaxRectangle2D {
	public int maximalRectangle(char[][] matrix) {
        if(matrix == null||matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] base = new int[n];
        int max =0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++)
                if(matrix[i][j] == '1')
                    base[j]++;
                else
                    base[j] = 0;
            max = Math.max(max, maxRec(base));
        }
        return max;
    }
    private int maxRec(int[] height){ 
        if(height == null || height.length == 0) return 0;
        int n = height.length;
        if(n == 1) return height[0];
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 0;right[n-1] = n-1;
        for(int i = 1; i < n; i++){
            if(height[i] > height[i-1])
                left[i] = i;
            else if(height[i] == height[i-1]){
                left[i] = left[i-1];
            }
            else{
                int tmp = left[i-1];
                while(tmp >0 && height[tmp-1] >= height[i] )
                    tmp = left[tmp-1];
                left[i] = tmp;
            }
        }
        for(int i = n-2; i >= 0; i--){
            if(height[i] > height[i+1])
                right[i] = i;
            else if (height[i] == height[i+1])
                right[i] = right[i+1];
            else{
                int tmp = right[i+1];
                while(tmp < n-1 && height[tmp+1] >= height[i])
                    tmp = right[tmp+1];
                right[i] = tmp;
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            int cur = (right[i] - left[i]+1)*height[i];
            max = Math.max(max, cur);
        }
        
        return max;
    }
}
