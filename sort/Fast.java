import java.util.Arrays;
import java.util.ArrayList;

public class Fast {
    public static void main(String[] args)
    {
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] points = new Point[N];
        double[] angs = new double[N];
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
        
        for (int i = 0; i < N; i++)  
        {
            Point[] copy = Arrays.copyOf(points, N); // make copy of all points
            Point current = points[i]; //current origining point
            Arrays.sort(copy, current.SLOPE_ORDER); //sort the copy , p[i]
            //copy[0] must be current, degeneration
            
            for(int k = 0; k<copy.length; k++) //store the calculated angles
                angs[k] = current.slopeTo(copy[k]);
            
            int ctr = 1;
            for(int j = 1; j< N-1; j++)
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
                    int lo = j-ctr+1;
                    int hi = j;
                    boolean flag = true;
                    for(int k = lo; k<hi+1; k++)
                    {
                        if (current.compareTo(copy[k]) > 0) 
                        {
                            flag = false;
                            break;
                        }
                    }
                    // current is the smallest in this tuples
                    // so that this is not redundency
                    if (flag)
                    {
                        Arrays.sort(copy, lo, hi+1);
                        //print the tuples to std output
                        StdOut.print(current.toString() + " -> ");
                        for(int k = lo; k < hi; k++)
                            StdOut.print(copy[k].toString() + " -> "); 
                        StdOut.println(copy[hi].toString()); 

                        current.drawTo(copy[hi]);
                    }
                }
                ctr = 1; //counter reset
            }
            copy = null;
        }
    }
}