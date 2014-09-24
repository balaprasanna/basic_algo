//观察，利用gray code规律
//也可以recursive
public class GrayCode {
	public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        //if(n == 0) return result;
        
        //i: shift i bit to left
        for(int i = 0; i < n; i++){
            int counter = result.size()-1;
            while(counter >= 0){
                result.add(result.get(counter) + (1<<i));
                counter --;
            }
        }
        return result;
    }
}
