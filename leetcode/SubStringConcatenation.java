import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//substring with concatenation of all words
//solve based on minimum windows 46
public class SubStringConcatenation {
	public static List<Integer> findSubstring(String S, String[] L) {
        int begin = -1;
        int n = S.length();
        int m = L.length;
        int t = L[0].length();
        int counter = 0;
        List<Integer> result = new ArrayList<Integer>();
        HashMap<String, Integer> hmap = new HashMap<>();
        for(String s: L){
        	if(hmap.get(s) != null)
        		hmap.put(s, hmap.get(s)+1);
        	else
        		hmap.put(s, 1);
        }
        HashMap<String, Integer> hasFound =new HashMap<>();
        for(String s:hmap.keySet())
        	hasFound.put(s, 0);
        for(int i = 0; i < t; i++){
        	for(int j = i; j<n-t+1; j=j+t){
        		if(begin == -1) begin = j;
        		String cur = S.substring(j, j+t);
        		if(hmap.get(cur) != null){
        			hasFound.put(cur, hasFound.get(cur)+1);
        			if(hasFound.get(cur) <= hmap.get(cur)) counter++;
        			if(counter == m){
        				String first = S.substring(begin, begin+t);
        				while(hasFound.get(first) == null || hasFound.get(first) > hmap.get(first)){
        					if(hasFound.get(first)!= null)
        						hasFound.put(first, hasFound.get(first)-1);
        					begin += t;
        					first = S.substring(begin, begin+t);
        				}
        				if(j+t-begin == m*t)
        					result.add(begin);
        			}
        		}
        	}
        	begin = -1;
        	counter = 0;
        	hasFound.clear();
        	for(String s:hmap.keySet())
            	hasFound.put(s, 0);
        }
        return result;
    }
	public static void main(String[] args){
		String S="lingmindraboofooowingdingbarrwingmonkeypoundcake";
		String[] L={"fooo","barr","wing","ding","wing"};
		System.out.print(findSubstring(S,L));
	}
}
