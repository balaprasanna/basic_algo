import java.util.ArrayList;
import java.util.List;

//leetcode
//Depth first, recursive solution
public class GenerateParenthese {
	private List<String> r = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        if (n == 0) {r.add(""); return r;}
        StringBuilder sb = new StringBuilder();
        generation(n,n,sb);
        return r;
    }
    private void generation(int left, int right, StringBuilder sb){
        if(left == 1){
            sb.append("(");
            for (int i = right; i > 0; i--)
                sb.append(")");
            r.add(sb.toString());
            sb.delete(sb.length()-left -right, sb.length());
        }
        else{
            sb.append('(');
            int len = sb.length();
            for (int i = 0; i <= right - left +1; i++){
                if (i == 0)
                    generation(left-1, right, sb);
                else{
                    sb.append(')');
                    generation(left-1, right-i,sb);
                }
            }
            sb.delete(len-1,sb.length());
        }
    }
}
