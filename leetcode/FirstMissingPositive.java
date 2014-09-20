//有点厉害，值得再做
public class FirstMissingPositive {
	public static int firstMissingPositive(int[] A) {
        if(A == null || A.length == 0) return 1;
        int l = 0;
        int r = A.length -1;
       while(true){
    	   while(l < r && A[l] > 0) l++;
    	   while(r>l && A[r] <= 0) r--;
    	   if (l == r) break;
    	   int tmp = A[l];
    	   A[l] = A[r];
    	   A[r] = tmp;
       };
       if(A[l] <= 0) l--;
        for(int i = 0; i <=l; i++){
            int p = Math.abs(A[i]);
            if(p<=l+1 && A[p-1] > 0)
                A[p-1] = -A[p-1];
        }
        for(int i = 0; i <= l; i++)
            if(A[i] > 0) return i+1;
        return l+2;
    }
	public static void main(String[] args){
		int[] A = {1,1};
		System.out.print(firstMissingPositive(A));
	}
}
