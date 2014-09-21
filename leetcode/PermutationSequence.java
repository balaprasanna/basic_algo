import java.util.ArrayList;
//mind fucker

public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int fib = 1;
        int dig =1;
        while(dig<n && fib < k)
            fib = fib*(++dig);
        //k larger than n!, no solution
        if(fib < k)
            return sb.toString();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = n; i >= 1; i--)
            list.add(0,i);
        for(int i = n; i>dig; i--)
            sb.append(list.remove(0));
        for(int i = dig; i>=1; i--){
                fib = fib/i;
                int pos = Math.max(0, k/fib + ((k%fib == 0)? -1: 0));
                sb.append(list.remove(pos));
                k = k % fib;
                if(k == 0)
                	k = fib;
        }
        return sb.toString();
    }
    public static void main(String[] args){
    	System.out.print(getPermutation(9,8));
    }
}
