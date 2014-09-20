//直方图相关的，虽然无论几遍pass都是O(n)时间
//但是用的space可是有差别
public class TrappingRainWater {
	//自己想出的方法，3 passes，O(n) space
	public int trap(int[] A) {
        if (A == null || A.length <= 1) return 0;
        int n = A.length;
        int[] lMax = new int[n];
        int[] rMax = new int[n];
        lMax[0] = A[0];
        rMax[n-1] = A[n-1];
        for(int i = 1; i < n; i++){
            if(A[i] > lMax[i-1]) 
                lMax[i] = A[i];
            else
                lMax[i] = lMax[i-1];
        }
        for(int i = n-2; i >= 0; i--){
            if(A[i] > rMax[i+1])
                rMax[i] = A[i];
            else
                rMax[i] = rMax[i+1];
        }
        int sum = 0;
        for(int i = 1; i <= n-2; i++)    
            sum += Math.min(lMax[i], rMax[i])-A[i];
        return sum;
    }
	//希望想出一个方法把空间降下来
	//想要one pass那肯定得两边同时扫
	//one pass, constant space的方法
	public static int trap2(int[] A){
		if (A == null || A.length <= 1) return 0;
        int n = A.length;
        int l = 0, r = n-1, all = 0, currentLevel = 0, block=0;
        while(l <= r){
        	if(Math.min(A[l], A[r]) > currentLevel){
        		all += (r-l+1)*(Math.min(A[l], A[r]) - currentLevel);
        		currentLevel = Math.min(A[l], A[r]);
        	}
        	if (A[l] <= A[r])
        		block += A[l++];
        	else
        		block += A[r--];
        }
        return all - block;
	}
	public static void main(String[] args){
		int[] A = {2,0,2};
		System.out.print(trap2(A));
	}
}
