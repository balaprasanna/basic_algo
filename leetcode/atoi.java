
public class atoi {
	public static int atoitest(String str) {
		String cont = str.trim();
        boolean sign = true; //true for positive
        int result = 0;
        for (int i = 0; i < cont.length(); i++){
            char cur = cont.charAt(i);
            if (i == 0){
                if (cur == '-') sign = false;
                else if (cur == '+') sign =true;
                else if (cur < '0' || cur > '9' ) break;
                else {
                    result = cur -'0';
                }
            }else {
                if (cur < '0' || cur > '9' ) break;
                if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && (cur -'7')>0))
                    {result = sign? Integer.MAX_VALUE: Integer.MIN_VALUE; return result;}
                result = result * 10 + cur - '0';
            }
        }
        return sign?result: -result;
    }
	public static void main(String[] args){
		String s = "-2147483649";
		System.out.print((-7/3));
		System.out.print(atoitest(s));
	}
}
