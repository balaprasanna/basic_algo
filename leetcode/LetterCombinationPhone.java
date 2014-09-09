import java.util.ArrayList;
import java.util.List;

//letter combinations of a phone number
//用DFS思路处理的permutation问题
public class LetterCombinationPhone {
	private String[] perm = {" ","","abc","def","ghi","jkl","mno", "pqrs", "tuv", "wxyz"};
	private List<String> l;
	public List<String> letterCombinations(String digits) {
        this.l = new ArrayList<String>();
        if (digits == null || digits.length() == 0) return l;
        StringBuilder sb = new StringBuilder();
        dfsVisit(digits,sb);
        return this.l;
    }
	private void dfsVisit(String d, StringBuilder sb){
		String dPerm = perm[d.charAt(0)-'0'];
		for (int i = 0; i < dPerm.length(); i++)
		{
			sb.append(dPerm.charAt(i));
			if (d.length() == 1)
				l.add(sb.toString());
			else
				dfsVisit(d.substring(1, d.length()),sb);
			sb.deleteCharAt(sb.length()-1);
		}
	}
}
