import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1) return intervals;
        Interval[] tmp = new Interval[intervals.size()];
        Arrays.sort(intervals.toArray(tmp), new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                if(i1.start < i2.start)
                    return -1;
                else if(i1.start == i2.start){
                    if(i1.end < i2.end)
                        return -1;
                    else if (i1.end == i2.end) 
                        return 0;
                    else 
                        return 1;
                }else
                    return 1;
            }
        });
        //Arrays.asList() returns a fixed size list
        intervals = new ArrayList(Arrays.asList(tmp));
        int hi = intervals.get(0).end;
        int low = intervals.get(0).start;
        for(int i =1 ; i < intervals.size();){
            Interval cur = intervals.get(i);
            if(cur.start <= hi){
                if(cur.end <= hi) intervals.remove(i); //included -> delete
                else{
                    hi = cur.end;
                    cur.start = low;
                    intervals.remove(i-1);
                }
            }else{
                low = cur.start;
                hi = cur.end;
                i++;
            }
        }
        return intervals;
    }
	private class Interval{
		int start;
		int end;
		 Interval() { start = 0; end = 0; }
		  Interval(int s, int e) { start = s; end = e; }
	}
	//2nd round code
	public List<Interval> merge(List<Interval> intervals) {
	        if(intervals.size() <= 1) return intervals;
	        Collections.sort(intervals, new Comparator<Interval>(){
	            @Override
	            public int compare(Interval p, Interval q){
	                if(p.start < q.start)
	                    return -1;
	                else if (p.start == q.start)
	                    return 0;
	                else
	                    return 1;
	            }
	        });
	        int k = 0;
	        for(int i = 1; i<intervals.size(); i++){
	            Interval cur = intervals.get(i);
	            while(intervals.get(k).end >= cur.start){
	                if(intervals.get(k).end < cur.end)
	                    intervals.get(k).end = cur.end;
	                intervals.remove(i);
	                if(i < intervals.size())
	                    cur = intervals.get(i);
	                else break;
	            }
	            k = i;
	        }
	        return intervals;
	    }
}
