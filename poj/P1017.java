import java.io.*;
import java.util.*;

public class P1017 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int[] numbers = new int[6];
        while(in.hasNextLine()){
            String[] tmp = in.nextLine().split(" ");
            for(int i = 0; i < 6; i++)
                numbers[i] = Integer.valueOf(tmp[i]);
            int ctr = numbers[5];
            for(int i = 4; i >=0; i--){
                if(numbers[i]!=0 ){
                    switch(i){
                        case 4: 
                            ctr += numbers[i];
                            numbers[0] = Math.max(0, numbers[0]- 11* numbers[i]);
                            break;
                        case 3:
                            ctr += numbers[i];
                            if(numbers[1] >= 5*numbers[i]){
                                numbers[1] -= 5*numbers[i];
                                break;
                            }
                            else{
                                numbers[0] = Math.max(0, numbers[0]-(20*numbers[i] - 4* numbers[1]));
                                numbers[1] = 0;
                                break;
                            }
                        case 2:
                            ctr += numbers[i]/4;
                            switch(numbers[i]%4){
                                case 0:
                                    break;
                                case 1:
                                    ctr += 1;
                                    if(numbers[1]>=5){
                                        numbers[1] -=5;
                                        numbers[0] = Math.max(0, numbers[0]-7);
                                        break;
                                    }else{
                                        numbers[0] = Math.max(0, numbers[0]-(27-4*numbers[1]));
                                        numbers[1] = 0;
                                        break;
                                    }
                                case 2:
                                    ctr+=1;
                                    if(numbers[1]>=3){
                                        numbers[1] -=3;
                                        numbers[0] = Math.max(0, numbers[0]-6);
                                        break;
                                    }else{
                                        numbers[0] = Math.max(0, numbers[0]-(18-4*numbers[1]));
                                        numbers[1] = 0;
                                        break;
                                    }
                                case 3:
                                    ctr+=1;
                                    if(numbers[1]>=1){
                                        numbers[1] -=1;
                                        numbers[0] = Math.max(0, numbers[0]-5);
                                        break;
                                    }else{
                                        numbers[0] = Math.max(0, numbers[0]-9);
                                        numbers[1] = 0;
                                        break;
                                    }
                            }
                            break;
                        case 1:
                            ctr += numbers[i]/9;
                            if(numbers[i]%9 != 0){
                                numbers[0] = Math.max(0, numbers[0]-(9-numbers[i]%9)*4);
                                ctr+=1;
                            }
                            break;
                        case 0:
                            ctr += numbers[i]/36;
                            if(numbers[i]%36 != 0)
                                ctr+=1;
                            break;
                    }
                }
            }
            if(ctr == 0)
                return;
            System.out.println(ctr);
        }
    }
}
