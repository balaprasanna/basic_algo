import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//3sum
public class Sum3 {
	public static List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i<num.length; i++)
            map.put(num[i], i);
        for (int i = 0; i<num.length - 2;i++){
            if (num[i] > 0) return result;
            int	first = num[i];
            for (int j = i+1; j<num.length -1; j++){
            	int second = num[j];
                if (first +second > 0) break;
                if (map.get(-first-second)!= null && map.get(-first-second)>j){
                    List<Integer> item = new ArrayList<Integer>(3);
                	item.add(first); item.add(second); item.add(-first-second);
                    result.add(item);
                }
                j = map.get(second);
            }
            i = map.get(first);
        }
        return result;
    }
	public static void main(String[] args){
		int[] test= {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		System.out.print(threeSum(test).toString());
	}
}
