//leetcode
public class RegularExpression {
	public static boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        if (s == null) return p == null;
        if (s.length() == 0 && p.length() == 0) return true;
        
        while (i<s.length()){
            if (j == p.length()) return false;
            if (s.charAt(i) == p.charAt(j)){
                if (j+1<p.length() && p.charAt(j+1) == '*'){
                    while(i+1<s.length() && s.charAt(i) == s.charAt(i+1)) i++;
                    i++;
                    if (j+1 == p.length() -1){
                        if (i == s.length() -1) return true;
                        else return false;
                    }else j=j+2;
                }else {i++; j++;}
            }else if (p.charAt(j)=='.'){
                if (j+1 == p.length()) {i++; j++;}
                else if (p.charAt(j+1) != '*'){j++; i++;}
                else if (j+1 == p.length() -1) return true;
                else{
                    j = j+2;
                    while(i<s.length() && s.charAt(i) != p.charAt(j)) i++;
                    if (i == s.length()) return false;
                }
            }else if (j+2<p.length() && p.charAt(j+1)=='*') j=j+2;
            else return false;
        }
        return true;
    }
	public static void main (String[] args){
		String s = "aab";
		String p = "c*a*b";
		System.out.print(isMatch(s,p));
	}
}
