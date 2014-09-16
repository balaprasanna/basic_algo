//leetcode divide two integers
//cast integer to long to avoid overflow
public class Divide2Integers {
	public int divide(int dividend, int divisor) {
        long divd = dividend;
        long divs = divisor;
        if (divd < 0) divd = - divd;
        if (divs < 0) divs = - divs;
        
        int res = 0;
        while(divd >= divs){
            long a = divs;
            int i;
            for (i = 1; a<=divd; i++)
                a = a << 1;
            res = res + (1<<(i-2));
            divd = divd - (divs<<(i-2));
        }
        return (dividend>0 ^ divisor>0)? -res: res;
    }
}
