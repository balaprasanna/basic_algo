
public class HuiWen {
	public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        int len = s.length();
        char[] sc = s.toCharArray();
        int x=1, y=1, max_len=1;
        boolean[][] pal = new boolean[len+1][len+1];
        //init
        for (int i = 1; i <= len; i++)
            for (int  j = 1; j <= len; j++)
            {
                if (i == j) pal[i][j] = true;
                else if (i+1 == j && sc[i-1] == sc[j-1]){
                        pal[i][j] = true;
                        if (max_len < 2){
                        	max_len = 2;
                            x = i; y = j;
                        }
                }else  pal[i][j] = false;
            }
        for (int l = 3; l <= len; l++)
            for (int i = 1; i<=len-l+1; i++){
                int j = i+l-1;
                if (pal[i+1][j-1] && sc[i-1] == sc[j-1]){
                    pal[i][j] = true;
                    if(l > max_len){
                        max_len = l;
                        x = i; y = j;
                    }
                }
            }
            return s.substring(x-1, y);
    }
	public static void main (String[] args){
		String s = "ccc";
		System.out.print(longestPalindrome(s));
	}
}
