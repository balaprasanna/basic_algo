//the worst ever prob
//记住函数Double.parseDouble(String s)
//记住try{} catch(Exception ex){}
//需要学习regular expression
public class ValidNumber {
	public boolean isNumber(String s) {
		try{
			s = s.trim();
	        int n = s.length();
	        if ( n == 0 || (s.charAt(n-1) != '.' && (s.charAt(n-1) - '0' < 0 || s.charAt(n-1) - '0' > 9 )) ) {
	            return false;
	        }
			Double.parseDouble(s);
			return true;
		}
		catch (NullPointerException | NumberFormatException ex){
			return false;
		}
    }
}
