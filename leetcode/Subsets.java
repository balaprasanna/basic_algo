import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//mature subsets generation algorithm
public class Subsets {
	static List<List<Integer>> result;
    static List<Integer> item;
    public static List<List<Integer>> subsets(int[] S) {
        result = new ArrayList<List<Integer>>();
        if(S == null) return result;
        item = new ArrayList<Integer>();
        //如果需要反向的sort
        //Arrays.sort(S, Collections.reverseOrder()); 
        Arrays.sort(S);
        
        int n = S.length;
        //注意乘方不是^
        int setNum = (int) Math.pow(2, n);
        int counter = 0;
        while(counter < setNum){
            for(int i = 0; i<n; i++){
            	//利用二进制数每个bit和subset里是否有每个元素的对应关系作为mask
                if((counter & (1<<i)) != 0)
                    item.add(S[i]);
            }
            result.add(item);
            item = new ArrayList<Integer>();
            counter++;
        }
        return result;
    }
    public static void main(String[] args){
    	int[] S = {0};
    	System.out.print(subsets(S));
    }
}
