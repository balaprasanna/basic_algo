import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class P1862 {   
  
    public static void main(String[] args) {   
        Scanner cin = new Scanner(System.in);   
           
        int num = Integer.valueOf(cin.nextLine()).intValue();   
        List<Double> list = new ArrayList<Double>();   
           
        for(int i = 0; i < num; i++)   
            list.add(Double.valueOf(cin.nextLine()));   
           
        Collections.sort(list);   
           
        double result, temp = 0;   
        double a, b = 0;   
           
        if(list.size() == 1)   
            result = Double.valueOf((Double)list.get(0)).doubleValue();   
        else  
        {   
            int index = list.size() - 1;   
            a = Double.valueOf((Double)list.get(index)).doubleValue();   
            b = Double.valueOf((Double)list.get(index-1)).doubleValue();   
               
            result = 2 * Math.sqrt(a * b);   
               
            for(int i = index - 2; i>=0; i--)   
            {   
                a = Double.valueOf((Double)list.get(i)).doubleValue();   
                result = 2 * Math.sqrt(a * result);   
            }   
        }   
        //new trick for precision  
        DecimalFormat df = new DecimalFormat("#.000");   
        System.out.println(df.format(result));   
    }   
  
}
