//leetcode: break word
//dynamic programming
//
import java.util.Set;

public class WordBreak {
	 public boolean wordBreak(String s, Set<String> dict) {
	        int len = s.length();
	        int max_len = 0; //for optimization, length of the longest word in dict
	        boolean[] seg = new boolean[len];
	        String sub = s.substring(0,1);
	        if(dict.contains(sub)) seg[0] = true;
	        else seg[0] = false;
	        for (int i = 1; i < len; i++)
	            if (dict.contains(s.substring(0,i+1))) seg[i] = true;
	            else {
	                for (int j = i-1; j>=0; j--)
	                    if (seg[j] && dict.contains(s.substring(j+1,i+1)))
	                    {
	                        seg[i] = true;
	                        break;
	                    }
	            }
	        return seg[len-1];
	    }
	 //second attemp, need reviewing
	 public boolean wordBreak2(String s, Set<String> dict) {
	        if(s == null || s.length() == 0) return false;
	        if(dict.size() == 0) return false;
	        boolean[] ret = new boolean[s.length()];
	        for(int i = 0; i < s.length();i++){
	            if(dict.contains(s.substring(0,i+1)))
	                ret[i] = true;
	            else{
	                for(int j = i-1; j >=0; j--)
	                    if(ret[j] && dict.contains(s.substring(j+1, i+1))){
	                        ret[i] = true;
	                        break;
	                    }
	            }
	        }
	        return ret[s.length()-1];
	    }
}
