import java.util.ArrayList;
//modificaiton in place

public class RemoveDupFromSortedArray2 {
	public static int removeDuplicates(int[] A) {
		if(A == null) return 0;
        if(A.length <= 2) return A.length;
        int counter = 0;
        int num = 1;
        for(int i = 1; i< A.length;i++){
            if(A[i] == A[num-1]){
                counter++;
                if(counter <2){
                    num++;
                    A[num-1] = A[i];
                }
            }else{
                counter = 0;
                num++;
                A[num-1] =A[i];
            }
        }
        return num;
    }
	public static void main(String[] args){
		int[] A={1,1,1,2};
		System.out.print(removeDuplicates(A));
	}
}
