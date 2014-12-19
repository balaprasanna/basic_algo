public class ReversWords{ 
    public String reverseWords(String s) { 
        if (s == null || s.length() == 0) return s; 
        int pre = 0; 
        StringBuilder sb = new StringBuilder(); 
        char[] sc = s.toCharArray(); 
        for (int i = 0; i < sc.length; i++) 
            if (sc[i] == ' '){ 
                if (i - pre > 0) {sb = sb.insert(0, sc, pre, i-pre); sb = sb.insert(0,' ');} 
                pre = i+1; 
            } 
        if (sc.length > pre) sb = sb.insert(0, sc, pre, sc.length-pre); 
        String result = sb.toString(); 
        if (result.length()>1 && result.charAt(0) == ' ') 
            result = result.substring(1, result.length()); 
        //if (sb.charAt(sb.length()-1) == ' ') 
        //    sb.deleteCharAt(sb.length()-1); 
        return result; 
    }
    //second time
    public String reverseWords2(String s) {
        if(s == null) return s;
        s = s.trim();
        if(s.length() == 0) return s;
        String[] words = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = words.length-1; i>=0; i--)
            if(words[i].length() > 0)
                sb.append(words[i]+" ");
        s = sb.toString();
        return s.trim();
    }
}