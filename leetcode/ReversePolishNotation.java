public class ReversePolishNotation { 
    public int evalRPN(String[] tokens) { 
        if (tokens == null || tokens.length == 0) return 0;  
        Stack<Integer> num = new Stack<Integer>(); 
        for (int i = 0; i<tokens.length; i++){ 
            String cur = tokens[i]; 
            if (cur.equals("+")) 
                num.push(num.pop()+num.pop()); 
            else if (cur.equals("-")) 
                num.push(-num.pop()+num.pop()); 
            else if (cur.equals("*")) 
                num.push(num.pop()*num.pop()); 
            else if (cur.equals("/")) 
                { 
                    int right = num.pop(); 
                    int left = num.pop(); 
                    num.push(left / right); 
                } 
            else 
                num.push(Integer.parseInt(cur)); 
        } 
        return num.pop(); 
             
    } 
}