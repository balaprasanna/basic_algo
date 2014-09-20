
public class Mul2Strings {
	public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int n1 = num1.length();
        int n2 = num2.length();
        int[] x = new int[n1];
        int[] y = new int[n2];
        int[] r= new int[n1+n2];
        int carrym = 0;
        int carrya = 0;
        
        for(int i = 0; i < n1; i++)
            x[i] = num1.charAt(n1 - 1- i)-'0';
        for (int i = 0; i < n2; i++)
            y[i] = num2.charAt(n2-1-i) - '0';
        for(int i = 0; i < n2; i++){
            if(y[i] != 0){
                carrym = 0;
                int j;
                for(j = 0; j < n1; j++){
                    int tmp = (y[i]*x[j]+carrym) % 10;
                    carrym = (y[i]*x[j]+carrym) / 10;
                    r[i+j] += carrya + tmp;
                    carrya = r[i+j]/10;
                    r[i+j] = r[i+j]%10;
                }
                if (carrym != 0){
                    r[i+j] += carrya + carrym;
                    carrya = r[i+j] / 10;
                    r[i+j] = r[i+j] % 10;
                    j++;
                }
                while(carrya != 0 ){
                    r[i+j] = r[i+j] + carrya;
                    carrya = r[i+j] /10;
                    r[i+j] = r[i+j] % 10;
                    j++;
                }
                
            }
            
        }
        StringBuilder sb = new StringBuilder();
        int len;
        for(len = r.length-1; len>=0; len--)
            if(r[len] != 0) break;
        for(int i =0; i <= len; i++)
            sb.insert(0, r[i]);
        return sb.toString();
        
    }
	public static void main(String[] args){
		String s1 = "9";
		String s2 = "9";
		System.out.print(multiply(s1,s2));
	}
}
