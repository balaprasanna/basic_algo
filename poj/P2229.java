import java.io.*;
import java.util.*;

import java.util.*;
public class P2229{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int[] arr=new int[1000001];
        arr[1]=1;
        arr[2]=2;
        for(int i=3;i< 1000001;i++)
        {
            if(i%2==0) 
                arr[i]=(arr[i-1]+arr[i/2])%1000000000;
            else arr[i]=arr[i-1];
        }
        int a=in.nextInt();
        System.out.println(arr[a]);
    }
}