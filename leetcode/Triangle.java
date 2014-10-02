//discuss里的第一个答案挺好的，提供一个思考思路
//DP -》overlapping subquestions -> DP
//top-down or bottom-up？
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
        int level = triangle.size();
        List<Integer> min = new ArrayList<Integer>(triangle.get(level-1));
        int len = min.size();
        for(int i = level -2; i >= 0; i--){
            len--;
            for(int j = 0; j <len; j++)
                min.set(j, triangle.get(i).get(j)+Math.min(min.get(j), min.get(j+1)));
        }
        return min.get(0);
    }
}
