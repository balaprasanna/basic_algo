
public class LongestCommonPre {
	public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String test = strs[0];
        StringBuilder sb = new StringBuilder(test);
        for (int i = 1; i<strs.length; i++){
            if (sb.length() == 0) break;
            if (strs[i].length() < sb.length())
                sb.delete(strs[i].length(), sb.length());
            for(int j = 0; j < sb.length(); j++){
                if (strs[i].charAt(j) != sb.charAt(j)){
                        sb.delete(j, sb.length());
                        break;
                } 
            }
        }
        return sb.toString();
    }
}
