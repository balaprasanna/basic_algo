
public class CountAndSay {
	public static String countAndSay(int n) {
        String s = "1";
        if (n <= 0) return "";
        for(int i = n-1; i > 0; i--)
            s = sparse(s);
        return s;
    }
    private static String sparse(String s){
        if (s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        char num = '1';
        char dig =s.charAt(0);
        for(int i = 1; i < n; i++)
        {
            char cur = s.charAt(i);
            if(cur == dig)
                num++;
            else{
                sb.append(num);
                sb.append(dig);
                dig = cur;
                num = '1';
            }
            if(i == n-1){
                sb.append(num);
                sb.append(dig);
            }
        }
    return sb.toString();
    }
    public static void main(String[] args){
    	int n =2;
    	System.out.print(countAndSay(n));
    }
}
