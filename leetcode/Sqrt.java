//bit manipulation
public class Sqrt {
	public static int sqrt(int x){
		if (x == 0)
			return x;
		int h = 0;
		while((long)(1 << h)*(long)(1 << h) <= x)
			h++;
		h --;
		int res = 1 << h;
		h--;
		while(h >= 0){
			if((long)(res | 1<< h)*(long)(res|1<<h) <= x)
				res |= 1<<h;
			h--;
		}
		return (int )res;
	}
	public static void main(String[] args){
		System.out.print(sqrt(1));
	}
}
