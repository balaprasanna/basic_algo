import java.util.Arrays;
import java.util.ArrayList;

public class Fast {
    private static ArrayList<Dummy> d = new ArrayList<Dummy>();
    private class  Dummy{
        public String str; //the result of p.toString, p is the largest point
        public Double ang; // the angle when print as segment  
        public Dummy(String s, Double a){
            str = s;
            ang = a;
        }
       
    }
     //my own version of contains
    private boolean checkdum(Dummy y){
        if (y == null) return false;
        if (d.size() == 0) return false;
        for (int i = 0; i < d.size(); i++)
        {
            Dummy x = d.get(i);
            if ((x.str.compareTo(y.str) == 0) &&
                 (Double.compare(x.ang, y.ang) == 0))
                return true;
         }
         return false;
    }
    
    public static void main(String[] args)
    {
        
        Fast name = new Fast();
        Fast.Dummy now = null;
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] points = new Point[N];
        int x, y;
        int num = 0;
        StdDraw.setXscale(0, 32768); // rescale the coordinate system
        StdDraw.setYscale(0, 32768);
        while(!in.isEmpty()){
           x = in.readInt();
           y = in.readInt();
           points[num] = new Point(x, y);
           points[num].draw(); //each point has to be drawn excatly once.
           num++;
        }
        //sort points according to natrual order
        Arrays.sort(points);

        
        //d is the list for redundency checking
        ArrayList<Dummy> d = new ArrayList<Dummy>();
        
        //the three very last points cannot start a qualifying segment
        for (int i = 0; i < N-3; i++)  
        {
            Point[] copy = Arrays.copyOfRange(points, i+1, N); //
            Point current = points[i];
            Arrays.sort(copy, current.SLOPE_ORDER); //sort the copy , p[i]
            double[] angs = new double[copy.length];
            for(int k = 0; k<copy.length; k++) //store the calculated angles
                angs[k] = current.slopeTo(copy[k]);
            
            int ctr = 1;
            for(int j = 0; j< copy.length-1; j++)
            {
                while (Double.compare(angs[j], angs[j+1]) == 0 )
                {
                    j++;
                    ctr++;
                    if (j == copy.length-1)  break;
                } 
                if (ctr >= 3)
                {
                    //remove redundency
                    //StdOut.println(angs[j-1]);
                    //copy the qualified ones to good
                    Point[] good = new Point[ctr+1];
                    good[0] = current;
                    for(int l = 1; l <ctr+1; l++)
                        good[l] = copy[j-ctr+l];
                    Arrays.sort(good);
                    //create relevant dummy
                    
                    now = name.new Dummy(good[good.length-1].toString(), angs[j-1]);
                    //StdOut.println(good[good.length-1].toString());
                    //StdOut.println(angs[j-1]);
                    if (!name.checkdum(now))
                    {
                        for(int l = 0; l< good.length-1; l++)
                            StdOut.print(good[l].toString() + " -> "); 
                        good[0].drawTo(good[good.length-1]);
                        StdOut.println(good[good.length-1].toString()); 
                        name.d.add(now);
                        //StdOut.println(name.d.size());
                    }
                }
                ctr = 1; //counter reset
            }
        }
    }

}