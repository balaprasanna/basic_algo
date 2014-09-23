//模拟题，没什么意思
public class TextJustification {
	public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        if(words == null) return result;
        
        int lineStart = 0;
        while(lineStart < words.length){
            int leftover = L;
            for(int j = lineStart; j<words.length; j++){
                if(leftover - words[j].length() > 0){
                    leftover = leftover - words[j].length() - 1;
                    if(j == words.length - 1){
                        result.add(format(words, lineStart, j, L)); 
                        lineStart = j+1;
                    }
                }
                else if(leftover - words[j].length() == 0)
                {
                    result.add(format(words, lineStart, j, L));
                    lineStart = j+1;
                    break;
                }
                else{
                    result.add(format(words, lineStart, j-1, L));
                    lineStart = j;
                    break;
                }
            }
        }
        return result;
    }
    //end inclusive
    private String format(String[] words, int start, int end, int L){
        StringBuilder sb = new StringBuilder();
        //Last line formatting
        if(end == words.length-1){
            for(int i = start; i <= end; i++)
                sb.append(words[i] + ' ');
            if (sb.length() > L)
                sb.deleteCharAt(L);
            while(sb.length() < L)
                sb.append(' ');
            return sb.toString();
        }
        //lines before Last line
        int numGap = end - start;
        int totalLen = 0;
        for(int i = start; i<= end; i++)
            totalLen += words[i].length();
        //there is only one word in this line
        if(numGap == 0){
            sb.append(words[start]);
            for(int i = totalLen; i < L; i++)
                sb.append(' ');
            return sb.toString();
        }
        
        String[] gaps = new String[numGap];
        for(int i = 0 ; i < numGap; i++)
            gaps[i] = "";
        int ind = 0;
        for(int i = L-totalLen; i >0; i-- ){
            gaps[ind] = gaps[ind] + ' ';
            ind = (ind +1)%numGap;
        }
        for(int i = start; i < end; i++){
            sb.append( words[i] );
            sb.append(gaps[i-start]);
        }
        sb.append(words[end]);
        return sb.toString();
    }
}
