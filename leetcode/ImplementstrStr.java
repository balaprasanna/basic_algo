//string matching
public class ImplementstrStr {
	//native method
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
}
