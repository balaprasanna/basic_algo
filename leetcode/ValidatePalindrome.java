
public class ValidatePalindrome {
	public boolean isPalindrome(String s) {
        if(s == null || s.length()<=1) return true;
        int n = s.length();
        int i = 0, j = n-1;
        while(i<j){
            while(i<j && !check(s.charAt(i))) i++;
            while(i<j && !check(s.charAt(j))) j--;
            if(i == j)
                return true;
            //pay attention to this method
            if(Character.toLowerCase(s.charAt(i))!= Character.toLowerCase(s.charAt(j)))
                return false;
            i++;
            j--;
        }
        return true;
    }
    private boolean check(char a){
       //pay attention to these 2 methods
    	if(!Character.isDigit(a) && !Character.isLetter(a))
            return false;
        return true;
    }
}
