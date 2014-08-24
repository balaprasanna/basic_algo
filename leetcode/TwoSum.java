import java.util.HashMap;


public class TwoSum {
	public static int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length <2) return null;
        int index1, index2 = 0;
        int nLen = numbers.length;
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>(nLen);
        for (int i = 0; i < nLen; i++)
            hmap.put(numbers[i], i+1);
        for (index1 = 1; index1 <= nLen; index1++)
            if (hmap.containsKey(target-numbers[index1 - 1]) && hmap.get(target - numbers[index1 - 1 ])!=index1)
                {
                    index2 = hmap.get(target - numbers[index1 - 1 ]);
                    break;
                }
        if (index2 == 0) return null;
        else{
            int[] result = {index1, index2}; return result;
        }
    }
	public static void main (String[] args){
		int[] numbers = {3,2,4};
		int target = 6;
		System.out.print(twoSum(numbers, target));
	}
	
}
