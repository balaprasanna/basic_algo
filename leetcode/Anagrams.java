
public class Anagrams {
	public List<String> anagrams(String[] strs) {
        if(strs == null || strs.length == 0) return null;
        List<String> result = new ArrayList<String>();
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        
        for(String s: strs){
            char[] sc = s.toCharArray();
            Arrays.sort(sc);
            String key = new String(sc);
            ArrayList<String> set = hm.get(key);
            if(set == null){
                set = new ArrayList<>();
                set.add(s);
                hm.put(key, set);
            }else
                set.add(s);
        }
        
        for(String s: hm.keySet()){
            ArrayList<String> set = hm.get(s);
            if(set.size()!=1)
                result.addAll(set);
        }
        return result;
    }
}
