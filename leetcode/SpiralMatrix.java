//没意思
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) return l;
        
        int x0 = 0;
        int y0 = 0;
        int x1 = matrix.length-1;
        int y1 = matrix[0].length-1;
        while(x0 < x1 && y0 < y1){
            int x = x0;
            int y = y0;
            while(y < y1) l.add(matrix[x][y++]);
            while(x < x1) l.add(matrix[x++][y]);
            while(y > y0) l.add(matrix[x][y--]);
            while(x > x0) l.add(matrix[x--][y]);
            x0++;y0++;
            x1--; y1--;
        }
        if(x0 > x1 || y0 > y1) return l;
        if(x0 == x1 && y0 == y1)
        {
            l.add(matrix[x0][y0]);
            return l;
        }else if(x0 == x1){
            while(y0 <= y1) l.add(matrix[x0][y0 ++]);
            return l;
        }else{
            while(x0 <= x1) l.add(matrix[x0 ++][y0]);
            return l;
        }
    }
}
