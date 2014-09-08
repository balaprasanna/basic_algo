import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//4 sum
//implementation without hashmap
public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) return r;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++){
            if (i == 0 || (i > 0 && num[i]>num[i-1])){
                int a = num[i];
                for (int j = i +1; j < num.length -2; j++){
                    if (j == i+1 || (j > i+1 &&num[j]> num[j-1])){
                        int b = num[j];
                        int s = num.length -1;
                        for (int k = j+1; k < s; k++){
                            if (k == j+1 || (k > j+1 && num[k]>num[k-1])){
                                int c = num[k];
                                if (a+b+c+num[s] == target) {
                                    List<Integer> item = new ArrayList<Integer>(4);
                                    item.add(a); item.add(b); item.add(c); item.add(num[s]);
                                    r.add(item);
                                }else if (a+b+c+num[s] >target){
                                    while( s>k && a+b+c+num[s] > target) s--;
                                    if (s == k) s++;
                                    else if (a+b+c+num[s] ==target){
                                        List<Integer> item = new ArrayList<Integer>(4);
                                        item.add(a); item.add(b); item.add(c); item.add(num[s]);
                                        r.add(item);
                                    } 
                                }
                            }
                        }
                    }
                }
            }
        }
        return r;
    }
}
