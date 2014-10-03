import java.util.HashSet;


public class LongestConsecutiveSeq {
	public int longestConsecutive(int[] num) {
        if(num == null) return 0;
        if(num.length <= 1) return num.length;
        
        //pay attention to hashset
        //用空间换时间
        HashSet<Integer> hs = new HashSet<>(num.length);
        for(int item: num)
            hs.add(item);
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < num.length; i++){
            if(hs.contains(num[i])){
                int ctr = 1;
                hs.remove(num[i]);
                int cur = num[i]-1;
                while(hs.contains(cur)){
                    ctr++;
                    hs.remove(cur);
                    cur --;
                }
                cur = num[i]+1; 
                while(hs.contains(cur)){
                    ctr++;
                    hs.remove(cur);
                    cur++;
                }
                max = Math.max(max, ctr);
            }
        }
        return max;
    }
}
