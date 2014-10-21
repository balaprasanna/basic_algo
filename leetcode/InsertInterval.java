import java.util.List;
//没意思

public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null || intervals.size() == 0)
        {
            intervals.add(newInterval);
            return intervals;
        }
        int low = newInterval.start;
        int hi = newInterval.end;
        int i;
        for(i = 0; i < intervals.size();){
            Interval cur = intervals.get(i);
            if(low > cur.end )
                i++;
            else{
                if(hi <= cur.end){
                    if(hi < cur.start)
                        intervals.add(i, newInterval);
                    else
                        cur.start = Math.min(low, cur.start);
                    return intervals;
                }
                else{
                    cur.end = hi;
                    cur.start = Math.min(low, cur.start);
                    //processing merge
                
                    i++;
                    while(i < intervals.size()){
                        if(cur.end >= intervals.get(i).start){
                            cur.end = Math.max(intervals.get(i).end, cur.end);
                            intervals.remove(i);
                        }else
                            break;
                    }
                    return intervals;
                }
            }
        }
        if(i == intervals.size())
            intervals.add(newInterval);
        return intervals;
    }
	private class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
		 }
	//2nd time
	public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
	        if(intervals.size() == 0)
	            intervals.add(newInterval);
	        else{
	            int p = -1, q = -1;
	            for(int i = 0; i < intervals.size(); i++){
	                if(p == -1 && intervals.get(i).end >= newInterval.start)
	                    p = i;
	                if(q == -1 && intervals.get(i).start > newInterval.end){
	                    q = i;
	                    if(i == 0){
	                        intervals.add(0, newInterval);
	                        return intervals;
	                    }
	                }
	                if(i == intervals.size()-1){
	                    if(p == -1){
	                        intervals.add(newInterval);
	                        return intervals;
	                    }else if(q == -1)
	                        q = intervals.size();
	                }
	                if(p == q && p > -1){
	                    intervals.add(p, newInterval);
	                    return intervals;
	                }
	            }
	            newInterval.start = Math.min(newInterval.start, intervals.get(p).start);
	            newInterval.end = Math.max(newInterval.end, intervals.get(q-1).end);
	            for(int i = p; i < q; i++)
	                intervals.remove(p);
	            intervals.add(p,newInterval);
	        }
	        return intervals;
	    }
}
