//while循环里一定要检查index out of range的问题啊！！！
public class SortColors {
	public void sortColors(int[] A) {
        if(A == null  || A.length <= 1) return;
        int n = A.length;
        int i = 0, j = n-1;
        while(i < j){
            while(i< j && A[i] == 0) i++;
            while(j> i && A[j] != 0) j--;
            if(i < j)
                swap(A, i, j);
        }
        while(i >=0 && A[i] != 0)
            i--;
        i++;
        j = n-1;
        while(i < j){
            while(i < j && A[i] == 1) i++;
            while(j > i && A[j] == 2) j--;
            if(i < j)
                swap(A,i,j);
        }
    }
    private void swap(int[] A, int p, int q){
        int tmp = A[p];
        A[p] = A[q];
        A[q] = tmp;
    }
}
