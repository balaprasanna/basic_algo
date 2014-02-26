import java.util.Arrays;
public class Brute {
   public static void main(String[] args)
   {
       String filename = args[0];
       In in = new In(filename);
       int N = in.readInt();
       Point[] points = new Point[N];
       int x, y;
       int ctr = 0;
       while(!in.isEmpty()){
           x = in.readInt();
           y = in.readInt();
           points[ctr++] = new Point(x, y);
       }
       
       StdDraw.setXscale(0, 32768); // rescale the coordinate system
       StdDraw.setYscale(0, 32768);
       for(int i = 0; i < N-3; i++)
       {    
            //StdOut.print("i=");
            //StdOut.println(i);
            Point p = points[i];
            for(int j = i+1; j < N-2; j++)
            {
                //StdOut.print("j=");
                //StdOut.println(j);
                double s1 = p.slopeTo(points[j]);
                for(int m = j+1; m < N-1; m++)
                {
                    //StdOut.print("m=");
                    //StdOut.println(m);
                    double s2 = p.slopeTo(points[m]);
                    if(Double.compare(s1, s2) == 0)
                    {
                        for (int n = m+1; n < N; n++)
                        {
                            //StdOut.print("n=");
                            //StdOut.println(n);
                            if(Double.compare(s2, p.slopeTo(points[n])) == 0)
                            {
                                Point[] good = new Point[4];
                                good[0] = points[i];
                                good[1] = points[j];
                                good[2] = points[m];
                                good[3] = points[n];
                                Arrays.sort(good);
                                for(int k=0; k < 3; k++)
                                {
                                    good[k].draw();
                                    good[k].drawTo(good[k+1]);
                                    StdOut.print(good[k].toString() + " -> ");
                                }
                                good[3].draw();
                                StdOut.println(good[3].toString());
                            } 
                        }
                    }
                }
            }
            
       }

   }
}