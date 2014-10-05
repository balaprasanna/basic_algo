//Boring
public class MaxPointsOnALine {
	//other's solution
	    public int maxPoints(Point[] points) {
	        if (points.length <= 2){
	            return points.length;
	        }
	        int result=1;

	      //A line is defined y=a/bx+c, so (a, b, c) will represent a unique line
	     // run through each point and calculate (a, b, c) that defines the lines of itself 
	     //with all the the remaining points 
	        for (int i=0; i<points.length; i++){
	            int max=0, countSame=0;
	            HashMap<String, Integer> hm = new HashMap<String, Integer>();
	            for (int j=i+1; j<points.length; j++){
	                if (points[i].x == points[j].x && points[i].y == points[j].y){
	                    countSame++;       //same points will just add to the result
	                }
	                else{
	                    String key = normalize(points[i],points[j]);
	                    if(hm.get(key) == null){
	                        hm.put(key, 1);
	                        if(max ==0){
	                            max++;
	                        }
	                    }
	                    else {
	                       int count = hm.get(key)+1;
	                       hm.put(key, count);

	                        if (count > max)
	                            max = count;
	                    }
	                }

	            }
	            result = Math.max(result, max+countSame+1);
	        }


	        return result;
	    }

	    //ax+by+c=0 or y=a/b x + c
	    private String normalize(Point p1, Point p2){
	        int a, b;
	        float c;

	        if (p1.x == p2.x){  //a line parallel to y axis
	            a = 1;
	            b = 0;
	            c = -1 * p1.x;
	        }
	        else if (p1.y == p2.y){ //a line parallel to x axis
	            a = 0;
	            b = 1;
	            c = p1.y;
	        }
	        else{
	            int gcd = gcd(Math.abs(p1.x-p2.x), Math.abs(p1.y-p2.y));
	            b = (p2.x-p1.x)/gcd;
	            a = (p2.y-p1.y)/gcd;
	            if (a*b<0){                   //if the slope<0, always put (-) in front of a 
	                a = -1 * Math.abs(a);
	                b = Math.abs(b); 
	            }
	            else {
	                a = Math.abs(a);
	                b = Math.abs(b); 
	            }
	            c = (float)(b*p1.y - a*p1.x)/(float)b;
	        }
	        return ""+a+"||"+b+"||"+c;     //use this presentation as a key

	    }

	    private int gcd(int x, int y) {
	        if (y == 0) {
	          return x;
	        }
	        return gcd(y, x % y);
	  }
}
