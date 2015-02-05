import java.io.*;
import java.util.*;

 public class P1328 {  
     static class Range implements Comparable<Range>{  
         double left,right;  
         public Range(double left,double right){  
             this.left = left;  
             this.right = right;  
         }      
         public int compareTo(Range range) {
             if(range.left == left){  
                 return ((Double)right).compareTo((Double)(range.right));  
             }else{  
                 return ((Double)left).compareTo((Double)(range.left));  
             }  
         }  
  }  

     
  public static void main(String[] args) {  
      Scanner scn = new Scanner(System.in);    
   
   PrintWriter out = new PrintWriter(System.out);  
       int n ,d,x,y,num;  
       double dx;  
       Range[] ranges;  
       int index = 0;  
       while(true){  
           num = 0;  
           n = scn.nextInt();  
           d = scn.nextInt();  
           if(n == 0){  
               break;  
           }  
           ranges = new Range[n];  
           for(int i = 0; i < n; i++){  
               x = scn.nextInt();  
               y = scn.nextInt();  
               if(y > d){  
                   num = -1;  
               }  
               dx = Math.sqrt(d*d - y*y);  
               ranges[i] = new Range(x - dx, x + dx);  
           }  
           Arrays.sort(ranges);
           if(num != -1){  
               num = calute(ranges);  
           }  
           out.format("Case %d: %d\n",++index,num);  
       }  
       out.flush();  
      
  }  
    
  private static int calute(Range[] ranges) {  
   int num = 1;  
   int n = ranges.length;  
   Range preRange = ranges[0],range;  
   for(int i = 1; i < n; i++){  
       range = ranges[i];  
       if(range.left >= preRange.left && range.left <= preRange.right){  
           preRange.left = range.left;  
           if(range.right < preRange.right){  
               preRange.right = range.right;  
           }  
       }else{  
           num++;  
           preRange = range;  
    }  
   }  
   return num;  
  }  
}