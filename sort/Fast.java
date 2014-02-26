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
            int ctr = 1;
            for(int j = 0; j< copy.length-1; )
            {
                while (Double.compare(current.slopeTo(copy[j]),current.slopeTo(copy[++j])) == 0 )
                {
                    ctr++;
                    if (j == copy.length-1) break;
                } 
                if (ctr >= 3)
                {
                    //redundency?
                    //qualified 
                    //print and draw the starting point
                    if ((j == copy.length-1)&& (Double.compare(current.slopeTo(copy[j-1]),current.slopeTo(copy[j])) == 0 )) j++;
                    StdOut.print(current.toString() + " -> "); 
                    current.draw();
                    current.drawTo(copy[j-ctr]);
                    for (int k = j-ctr; k < j-1; k++)
                    {
                        StdOut.print(copy[k].toString() + " -> ");
                        copy[k].draw();
                        copy[k].drawTo(copy[k+1]);
                    }
                    copy[j-1].draw();    
                    StdOut.println(copy[j-1].toString());
                }
                ctr = 1; //counter reset
            }
        }
        
        
    }
}