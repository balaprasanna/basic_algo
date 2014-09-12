//string matching
public class ImplementstrStr {
	//native method
	//time complexity: O((n-m+1)*m)
	public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return null;
        if (needle == "") return haystack;
        if (haystack.length() == 0) return null;
        String pointer = null;
        int index = 0;
        for (int i = 0; i<=haystack.length()-needle.length(); i++){
            pointer = haystack.substring(i,i+needle.length());
            if (pointer.equals(needle)) return haystack.substring(i);
        }
        return null;
    }
	//Rabin-Karp
	public String RabinKarp(String haystack, String needle){
		return "";
	}
	
	//KMP
	public static String KMP(String haystack, String needle){
		//corner cases
		if (haystack == null || needle == null) return null;
        if (needle == "") return haystack;
        
		int n = haystack.length();
		int m = needle.length();
		int[] pi = prefixFunctionGenerator(needle);
		int accept = m;
		int q = 0; //matching state
		for(int i = 0; i < n; i++){
			while(q>0 && needle.charAt(q)!=haystack.charAt(i))
				q = pi[q+1]-1;
			if(needle.charAt(q) == haystack.charAt(i))
				q++;
			if(q == m)
				return haystack.substring(i-m+1);
		}
		return null;
	}
	//prefix-function generator of KMP
	private static int[] prefixFunctionGenerator(String needle){
		int m = needle.length();
		int[] pi = new int[m+1];
		pi[0] = m+1; //not used value
		pi[1] = 0;
		int q = 0; //matching state
		for (int i = 2; i <= m; i++){
			while(q> 0 && needle.charAt(q) != needle.charAt(i-1))
				q = pi[q];
			if(needle.charAt(q) == needle.charAt(i-1))
				q++;
			pi[i] = q;
		}
		return pi;
	}
	public static void main(String[] args){
		
		System.out.print(KMP("babba","bbb"));
	}
}
