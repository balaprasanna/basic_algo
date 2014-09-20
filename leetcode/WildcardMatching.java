//TLE solution
public class WildcardMatching {
	private String s;
    private String p;
    public boolean isMatch(String s, String p) {
        if(s == null || s.length() == 0){
            if (p == null || p.length() == 0) return true;
            else return false;
        }
        if( p == null || p.length() == 0){
            if (s == null || s.length() == 0) return true;
            else return false;
        }
        this.s = s;
        this.p = p;
        
        return checkRec(0,0);
    }
    //position x in string s
    //position y in string p
    private boolean checkRec(int x, int y){
        int ns = s.length();
        int np = p.length();
        if (x == ns && y == np) return true;
        if (y == np){
            if(p.charAt(y-1) == '*') return true;
            else if (x < ns) return false;
        }
        if (x == ns && y < np){
            while(y < np){
                if(p.charAt(y) != '*') return false;
                y++;
            }
            return true;
        }
        char cs = s.charAt(x);
        char cp = p.charAt(y);

        if( cp == '?')
            return checkRec(x+1, y+1);
        else if (cp != '*'){
            if (cs == cp)
                return checkRec(x+1, y+1);
            else
                return false;
        }else{
            // cp == '*'
            while(y < np && p.charAt(y) == '*') y++;
            while( x<ns && !checkRec(x,y))
                x++;
            if (x == ns) return false;
            else return true;
        }
    }
}
