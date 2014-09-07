//leetcode
public class Solution {
    public int threeSumClosest(int[] num, int target)  {
        Arrays.sort(num);
        HashMap<Integer, Integer> map = new HashMap<>();
        int dist = num[0]+num[1]+num[2] - target;
        for (int i = 0; i<num.length; i++)
            map.put(num[i],i);
        for (int i = 0; i<num.length-2; i++){ 
            int first = num[i];
            if (first - target >= Math.abs(dist) ) break;
            int k = num.length-1;
            for(int j = i+1; j<k; j++){
                int second = num[j] ;
                if (map.get(target-first-second)!=null) return target;
                /*
                for (int s = 1; s <Math.abs(dist); s++){
                    if (map.get(target+s-first-second)!= null) {dist = s; break;}
                    if (map.get(target-s-first-second)!= null) {dist = -s; break;}
                }*/
                int oldSum = first + second + num[k];
                if (oldSum - target < 0){
                    if (Math.abs(dist) > target - oldSum)
                            dist = oldSum - target;
                }else {
                    for (k=k-1; k > j; k--){
                        if (oldSum - target >0 && first+second+num[k] <0){
                            if (Math.abs(dist) > oldSum-target) dist = oldSum - target;
                            if (Math.abs(dist) > Math.abs(first+second+num[k] - target))
                                {dist = first+second+num[k] - target; k++;}
                            break;
                        }
                        oldSum = first + second + num[k];
                        if (k == j+1 && Math.abs(dist)>first+second+num[k]-target)
                            dist = first+second+num[k]-target;
                    }
                }
                j = map.get(second);
            }
            i = map.get(first);
        }
        return target+dist;
    }
}
