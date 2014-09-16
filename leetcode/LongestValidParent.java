//https://oj.leetcode.com/problems/longest-valid-parentheses/
public class LongestValidParent {
	public static int longestValidParentheses(String s) {
        int n = s.length();
        int max = 0;
        int counter = 0; //used as a stack
        int startIndex = -1;
        for(int i = 0; i < n; i++){
            if(startIndex == -1) startIndex = i;
            if(s.charAt(i) == '(') counter++;
            else counter--;
            if (counter == 0)
                max = (i+1-startIndex >max)? i+1-startIndex: max;
            else if(counter<0){
                counter = 0;
                startIndex = -1;
            }
            
        }
        if(counter>0){
        	int c = 0;
        	int endIndex = -1;
            for(int i = n-1; i>=startIndex; i--){
            	if(endIndex == -1) endIndex = i;
            	if (s.charAt(i) == '(') c--;
            	else c++;
            	if(c == 0)
            		max = (endIndex+1-i>max)?endIndex+1-i:max;
            	else if(c<0){
            		c = 0;
            		endIndex = -1;
            	}
            }
        }
        return max;
    }
	public static void main(String[] args){
		String s = ")(((((()())()()))()(()))(";
		System.out.print(longestValidParentheses(s));
	}
}
