//DP & storage
//need reviewing
public class WordBreak2 {
	public List<String> wordBreak(String s, Set<String> dict) {
        Map<Integer, List<String>> validMap = new HashMap<Integer, List<String>>();

        // initialize the valid values
        List<String> l = new ArrayList<String>();
        l.add("");
        validMap.put(s.length(), l);

        // generate solutions from the end
        for(int i = s.length() - 1; i >= 0; i--) {
            List<String> values = new ArrayList<String>();
            for(int j = i + 1; j <= s.length(); j++) {
                if (dict.contains(s.substring(i, j))) {
                    for(String word : validMap.get(j)) {
                        values.add(s.substring(i, j) + (word.isEmpty() ? "" : " ") + word);
                    }
                }
            }
            validMap.put(i, values);
        }
        return validMap.get(0);
    }
	//second attemp

	    private List<String> ret;
	    private List<List<Integer>> traceback; 
	    public List<String> wordBreak2(String s, Set<String> dict) {
	        ret =  new ArrayList<String>();
	        traceback =  new ArrayList<List<Integer>>(s.length());
	        for(int i = 0; i < s.length(); i++){
	            traceback.add(new ArrayList<Integer>());
	            if(dict.contains(s.substring(0,i+1)))
	                traceback.get(i).add(-1);
	            for(int j = i-1; j >=0; j--)
	                if(traceback.get(j).size()>0 && dict.contains(s.substring(j+1, i+1)))
	                    traceback.get(i).add(j);
	        }
	        StringBuffer sb = new StringBuffer(s);
	        if(traceback.get(s.length()-1).size() == 0) return ret;
	        gen(s.length()-1, s);
	        return ret;
	    }
	    private void gen(int i, String s){
	        StringBuffer sb = new StringBuffer(s);
	        for(int a : traceback.get(i)){
	            if(a == -1)
	                ret.add(s);
	            else{
	                sb.insert(a+1, ' ');
	                gen(a, sb.toString());
	                sb.deleteCharAt(a+1);
	            }
	        }
	    }
}
