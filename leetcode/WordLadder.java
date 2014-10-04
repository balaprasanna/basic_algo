import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
//太捷豹烦了这个题

public class WordLadder {
	public static int ladderLength(String start, String end, Set<String> dict) {
		HashMap<String, Integer> hmap = new HashMap<>();
        hmap.put(start, 0);
        Queue<String> qu = new LinkedList<String>();
        qu.add(start);
        int dist = 0;
        while(qu.size() > 0){
            int ctr = qu.size();
            if(hmap.get(end) != null)
                return hmap.get(end) +1;
            while(ctr>0){
                String cur = qu.poll();
                /*
                for(String item: dict)
                    if(!hmap.containsKey(item) && isNeighbor(item, cur)){
                        qu.add(item);
                        hmap.put(item, dist+1);
                    }
                */
                char[] cs = cur.toCharArray();
                for (int i = 0; i < cur.length(); i++) {
                    char save = cs[i];
                    for (int j = 0; j < 26; j++) {
                        cs[i] =(char)('a'+j);
                        String newWord = new String(cs);
                        if (dict.contains(newWord) && !hmap.containsKey(newWord)) {
                            hmap.put(newWord, dist+1);
                            qu.add(newWord);
                        }
                    }
                    cs[i] = save;
                }
                ctr --;
            }
            dist++;
        }
        return 0;
    }
    //calculate distance
	/*
    private int distance(String a, String b){
        int len = a.length();
        int ctr = 0;
        for(int i = 0; i< len; i++){
            if(a.charAt(i) != b.charAt(i))
                ctr++;
        }
        return ctr;
    }
    private boolean isNeighbor(String a, String b){
        int ctr = 0;
        for(int i =0; i< a.length(); i++){
            if(a.charAt(i) != b.charAt(i))
                ctr++;
            if(ctr == 2) return false;
        }
        return true;
    }
    */
    public static void main(String[] args){
    	String start = "hit";
    	String end = "dog";
    	Set<String> dict = new HashSet<String>();
    	dict.add("hot");
    	dict.add("cog");
    	dict.add("dot");
    	dict.add("dog");
    	dict.add("hit");
    	dict.add("lot");
    	dict.add("log");
    	System.out.print(ladderLength(start, end, dict));
    }
}
