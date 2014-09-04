
public class isPalindrome {
	public static boolean isPalindromeTest(int x) {
        if (x < 0) return false; //negative number is not palindrome
        if (x/10 == 0) return true;
        int d = 1;
        while(!((x/d)<10)) d*=10 ;
        while (d>1){
            int first = x/d;
            int last = x % 10;
            if (first != last) return false;
            x = x - first*d;
            x = x/10;
            d = d/100;
        }
        return true;
    }
	public static void main (String[] args){
		int a = 1000000001;
		System.out.print(isPalindromeTest(a));
	}
}
