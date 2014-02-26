import java.util.Arrays;

public class Fast {
    public static void main(String[] args)
    {
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] points = new Point[N];
        int x, y;
        int num = 0;
        while(!in.isEmpty()){
           x = in.readInt();
           y = in.readInt();
           points[num++] = new Point(x, y);
        }
        StdDraw.setXscale(0, 32768); // rescale the coordinate system
        StdDraw.setYscale(0, 32768);
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
                    //redundency?
                    
                    //copy the qualified ones to good
                    Point[] good = new Point[ctr+1];
                    good[0] = current;
                    for(int l = 1; l <ctr+1; l++)
                        good[l] = copy[j-ctr+l];
                    Arrays.sort(good);
                    
                    //print and draw the starting point
                    for(int l = 0; l< good.length-1; l++)
                    {
                        good[l].draw();
                        good[l].drawTo(good[l+1]);
                        StdOut.print(good[l].toString() + " -> "); 
                    }
                    good[good.length-1].draw();
                    StdOut.println(good[good.length-1].toString()); 
                }
                ctr = 1; //counter reset
            }
        }
    }
}