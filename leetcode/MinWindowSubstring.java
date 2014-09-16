import java.util.HashMap;
//
public class MinWindowSubstring {
	public static String minWindow(String S, String T) {
        int n = S.length();
        int m = T.length();
        int begin = -1;
        int counter = 0;
        int min = Integer.MAX_VALUE;
        int minbegin = -1;
        HashMap<Character, Integer> htable = new HashMap<>();
        for (int i = 0; i < m; i++){
            if (htable.get(T.charAt(i)) != null)
            	htable.put(T.charAt(i), htable.get(T.charAt(i))+1);
            else    
            	htable.put(T.charAt(i), 1);
        }
        HashMap<Character, Integer> hasFound = new HashMap<>(htable.size());
        for (char c: htable.keySet())
            hasFound.put(c, 0);
        
        for (int i = 0; i < n; i++){
            char cur = S.charAt(i);
            if (htable.containsKey(cur)){
                if (begin == -1) begin = i;
                hasFound.put(cur, hasFound.get(cur)+1);
                if(hasFound.get(cur) <= htable.get(cur)) counter++;
                if(counter == m){
                    while(hasFound.get(S.charAt(begin)) == null || hasFound.get(S.charAt(begin))>htable.get(S.charAt(begin))){
                    	if (hasFound.get(S.charAt(begin))!=null)
                    		hasFound.put(S.charAt(begin), hasFound.get(S.charAt(begin))-1);
                    	begin++;
                    }
                    if (i+1 - begin ==m) return S.substring(begin, i+1);
                    if (min > i+1-begin){
                    	min = i+1-begin;
                    	minbegin = begin;
                    }
                }
            }
        }
        if (counter < m) return "";
        else return S.substring(minbegin, minbegin+min);
    }
	public static void main(String[] args){
		String S="cabwefgewcwaefgcf";
		String T="cae";
		System.out.print(minWindow(S,T));
	}
}
