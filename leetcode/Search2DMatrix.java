//binary search
public class Search2DMatrix {
	private int m;
    private int n;
    private int[][] ma;
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;
        ma = matrix;
        m = ma.length;
        n = ma[0].length;
        int l = 0, h = m*n-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(at(mid) == target) return true;
            else if(at(mid) > target)
                    h = mid -1;
            else
                l = mid+1;
        }
        return false;
    }
    private int at(int ind){
        int x = ind/n;
        int y = ind-x*n;
        return ma[x][y]; 
    }
}
