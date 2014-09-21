
public class AddBinary {
	public static String addBinary(String a, String b) {
        if(a == null){
            if(b == null) return "0";
            else return b;
        }
        if(b == null) return a;
        int na = a.length();
        int nb = b.length();
        if(na == 0) return b;
        if(nb == 0) return a;
        
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int size = Math.max(na,nb)+1;
        int[] re = new int[size];
        int carry = 0;
        for(int i = 0; i <size ; i++)
        {
            int tmp =carry+((i>= na)?0:(ac[na-1-i] - '0'))+((i>=nb)?0:(bc[nb-1-i]-'0'));
            re[size-1-i] = tmp % 2;
            carry = tmp/2;
        }
        StringBuilder sb = new StringBuilder();
        if(re[0] != 0)
            sb.append(re[0]);
        for(int i = 1; i<size; i++)
            sb.append(re[i]);

        return sb.toString();
    }
	public static void main(String[] args){
		String a = "100";
		String b= "110010";
		System.out.print(addBinary(a,b));
		
	}
}
