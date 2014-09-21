//trivial
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
        if(s == null) return 0;
        //get rid of any leading or trailing spaces
        s = s.trim();
        if(s.length() == 0) return 0;
        int len = 0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) != ' ')
                len++;
            else break;
        }
        return len;
    }
}
