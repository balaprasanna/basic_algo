import java.util.ArrayList;
import java.util.List;
//this method is not good, use recursive next time

public class RestoreIPAddress {
	public static List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
        if(s == null || s.length() == 0) return result;
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        if(len > 12) return result;
        
        for(int i = 1; i<Math.min(len-2,4); i++){
            if(i == 2 && sb.charAt(i-2)== '0') break;
            if(i == 3 && Integer.valueOf(sb.substring(0,3))> 255) break;
            
            sb.insert(i,'.');
            for(int j = i+2; j <Math.min(len, i+5); j++){
                if(j == i+3 && sb.charAt(i+1) == '0') break;
                if(j == i+4 && Integer.valueOf(sb.substring(i+1, j)) > 255) break;
                
                sb.insert(j,'.');
                for(int k = j+2; k <Math.min(len+2, j+5) ; k++){
                    if(k == j+3 && sb.charAt(j+1) == '0') break;
                    if(k == j+4 && Integer.valueOf(sb.substring(j+1,k))> 255) break;
                    sb.insert(k, '.'); 
                    if(len+2 - k == 1 || (len+2-k == 2 && sb.charAt(k+1) != '0') ||
                    (len+2-k == 3 && Integer.valueOf(sb.substring(k+1)) <= 255 && sb.charAt(k+1) !='0'))
                       result.add(sb.toString());
                       
                    sb.deleteCharAt(k);
                }
                sb.deleteCharAt(j);
            }
            sb.deleteCharAt(i);
        }
        return result;
    }
	public static void main(String[] args){
		String s = "172162541";
		restoreIpAddresses(s);
		//System.out.print();
	}
}
