import java.util.HashMap;

//leetcode the longest no repeating substring
public class NoRepeatingSubstring {
	public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        HashMap<Character, Integer> position = new HashMap<Character, Integer>();
        int maxCtr =0, curCtr =0, start =0;
        for (int i = 0; i < s.length(); i++){
            char curChar = s.charAt(i);
            if (position == null ||! position.containsKey(curChar)){
                position.put(curChar, i);
                curCtr++;
            }else{
                int last = position.put(curChar,i);
                if (last >= start){
                	curCtr = i - last;
                	start = last +1;
                }else curCtr ++;
            }
            maxCtr = (curCtr > maxCtr)? curCtr : maxCtr;
        }
        return maxCtr;
    }
	public static void main (String[] args){
		String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		System.out.print(lengthOfLongestSubstring(s));
	}

}
