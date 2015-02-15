import java.io.*;
import java.util.*;

class student implements Comparable<student>{
    int score, aid;
    public student (int s, int a){
        this.score = s;
        this.aid = a;
    }
    public int compareTo(student o){
        return this.score-o.score;
    }
}
public class P2010{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int N = in.nextInt();//admit
        int C = in.nextInt();//all
        int F = in.nextInt();//sum
        student[] ss = new student[C];
        for(int i = 0; i < C; i++)
            ss[i] = new student(in.nextInt(), in.nextInt());
        Arrays.sort(ss);
        if(N == 1){
            for(int i = C-1; i >=0; i--)
                if(ss[i].aid <=F){
                    System.out.println(ss[i].score);
                    return;
                }
            System.out.println(-1);
            return;
        }
        int start = N/2;
        int end = C-1-N/2;
        long[] leftsum = new long[C];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(N/2, Collections.reverseOrder());
        for(int i =0 ;i < start; i++){
            pq.add(ss[i].aid);
            leftsum[start] += ss[i].aid;
        }
        for(int i = start+1; i <= end; i++){
            if(ss[i-1].aid < pq.peek()){
                leftsum[i] = leftsum[i-1]-pq.poll()+ss[i-1].aid;
                pq.add(ss[i-1].aid);
            }
            else
                leftsum[i] = leftsum[i-1];
        }
        //form right to left
        pq = new PriorityQueue<Integer>(N/2, Collections.reverseOrder());;
        long[] rightsum = new long[C];
        for(int i = C-1; i > end; i--){
            pq.add(ss[i].aid);
            rightsum[end] += ss[i].aid;
        }
        for(int i = end-1; i >= start; i--){
            if(ss[i+1].aid < pq.peek()){
                rightsum[i] = rightsum[i+1] - pq.poll()+ss[i+1].aid;
                pq.add(ss[i+1].aid);
            }else
                rightsum[i] = rightsum[i+1];
        }
        for(int i = end; i >= start; i--)
            if(leftsum[i]+rightsum[i]+ss[i].aid <= F){
                System.out.println(ss[i].score);
                return;
            }
        System.out.println(-1);
    }
}