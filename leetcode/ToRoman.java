//Integer to Roman
public class ToRoman {
	public static String intToRoman(int num) {
        int[] base = {1000, 500, 100, 50, 10, 5, 1};
        char[] baseC = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        String result = "";
        int step = 1;
        for (int i =0 ;i < base.length; i++){
            if (num == 0) return result;
            while (num - base[i] >= 0){
                result += baseC[i];
                num -= base[i];
            }
            if (num == 0) return result;
            if (i+1+step < base.length && num - base[i]+base[i+1+step] >=0){
                result = result+ baseC[i+1+step]+baseC[i];
                num -=base[i]-base[i+1+step];
            }
            step = (step + 1)%2;
        }
        return result;
    }
	public static void main (String[] args){
		int s = 14;
		System.out.print(intToRoman(s));
	}
}
