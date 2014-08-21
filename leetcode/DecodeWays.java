//solution for leetcode: decode ways
//link: https://oj.leetcode.com/problems/decode-ways/
//dynamic programming: 3 different recurrent formula, including the fibbonacci one
//easy but need to consider different cases carefully: which 2 digits can be bound together, which can not
public class DecodeWays {
	public static int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int cur = Character.getNumericValue(s.charAt(0));
        if (cur == 0) return 0;
        if (s.length() == 1) return 1;
        int[] count = new int[s.length()+1];
        count[0] = 1;
        count[1] = 1;
        int pre = cur;
        for (int i = 2 ; i <= s.length(); i++){
            cur = Character.getNumericValue(s.charAt(i-1));
            if (cur == 0){
                if (pre == 0 || pre > 2) return 0;
                else count[i] = count[i-2];
            }else{
                if (pre*10+cur > 26 || pre == 0)
                    count[i] = count[i-1];
                else
                    count[i] = count[i-1] + count[i-2];
            }
            pre = cur;
        }
        return count[s.length()];
    }
	public static void main(String[] args){
		System.out.print(numDecodings("10"));
	}

}
