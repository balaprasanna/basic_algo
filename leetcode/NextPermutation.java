//https://oj.leetcode.com/problems/next-permutation/
// 48AC
public class NextPermutation {
	public void nextPermutation(int[] num) {
        if(num == null || num.length == 0) return;
        int s = -1;
        int n = num.length;
        for(int i = 0; i<n-1; i++){
            if(num[i] < num[i+1]) s = i;
        }
        if(s == -1){
            int temp;
            for(int j = 0; j<n/2; j++){
                temp = num[j];
                num[j] = num[n-1-j];
                num[n-1-j] = temp;
            }
        }else{
            int small = num[s];
            int minBig = num[s+1];
            int dest = s+1;
            for(int j = s+2; j<n; j++)
                if(num[j]>small){
                    if(num[j] < minBig){
                        minBig = num[j];
                        dest = j;
                    }
                }
            num[s] = minBig;
            num[dest] = small;
            int temp;
            while(dest < n-1 && num[dest] < num[dest+1]){
                num[dest] = minBig;
                num[dest+1] = small;
                dest++;
            }
            for(int k = 0; k < (n-1-s)/2; k++ ){
                temp = num[s+1+k];
                num[s+1+k] = num[n-1-k];
                num[n-1-k] = temp;
            }
        }
    }
}
