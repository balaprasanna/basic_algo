import java.util.HashMap;

//
public class RomanToInt {
	public int romanToInt(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('M',1000);
        hm.put('D', 500);
        hm.put('C', 100);
        hm.put('L', 50);
        hm.put('X', 10);
        hm.put('V', 5);
        hm.put('I', 1);
        int num = 0;
        int pre = 0;
        for (int i = s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            int dig = hm.get(ch);
            if (dig >= pre ) num +=dig;
            else num -=dig;
            pre = dig;
        }
        return num;
    }
}
