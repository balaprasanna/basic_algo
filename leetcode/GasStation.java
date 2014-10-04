
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int check = 0;
        for(int i = 0; i < n; i++)
            check = check+gas[i]-cost[i];
        if(check < 0) return -1;
        
        for(int shift = 0; shift<n; ){
            int vol = 0;
            for(int i = 0; i < n; i++){
                int cur = (i+shift)%n;
                vol = vol + gas[cur] - cost[cur];
                if(vol <0) {
                    //pay attention to this time reduction
                    shift = cur+1;
                    break;
                }
            }
            if(vol >= 0) return shift;
        }
        return -1;
    }
}
