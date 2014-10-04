import java.util.ArrayList;
import java.util.List;

//自己想出来的，zan
public class PalindromePartition {
	public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(s == null || s.length() == 0) return result;
        int n = s.length();
        String left = "";
        for(int i =1; i < n; i++){
            left = left+s.charAt(i-1);
            if(isPalin(left)){
                List<List<String>> right = partition(s.substring(i));
                for(List<String> item: right){
                    item.add(0, left);
                    result.add(item);
                }
            }
        }
        if(isPalin(s)){
            List<String> item = new ArrayList<String>();
            item.add(s);
            result.add(item);
        }
        return result;
    }
    private boolean isPalin(String s){
        if(s == null || s.length()<=1) return true;
        int i = 0, j = s.length()-1;
        while(i<j){
            if(s.charAt(i) == s.charAt(j))
                {i++; j--;}
            else
                return false;
        }
        return true;
    }
}
