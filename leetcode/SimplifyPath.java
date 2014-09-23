import java.util.Stack;

//string s.split()
public class SimplifyPath {
	public static String simplifyPath(String path) {
		if(path == null) return "";
        if(path.length() == 0) return path;
        Stack<String> stack = new Stack<>();

        //split path into directory names
        String[] names = path.split("/");
        for(String name: names){
            if(name.length() > 0){
                if(name.equals("..")){
                	if(stack.size() > 0)
                		stack.pop();
                }
                else if(!name.equals("."))
                    stack.push(name);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(stack.size() > 0)
            sb.insert(0,'/'+ stack.pop());
        if (sb.length() == 0)
            sb.append("/");
        return sb.toString();
    }
	public static void main(String[] args){
		String s = "/..";

		System.out.print(simplifyPath(s));
	}
}
