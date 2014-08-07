public class ZigZag { 
    public String convert(String s, int nRows) { 
        if (nRows == 1) return s; 
        char[] sc = s.toCharArray(); 
        if (sc.length <= nRows) return s; 
        int step = 1, index = 0; 
        int len = sc.length/nRows + 1; 
        String[] line = new String[nRows]; 
        for (int i = 0; i < nRows; i++) 
            line[i] = ""; 
        for (int i = 0; i < sc.length; i++){ 
            int temp = i % (2*nRows -2); 
            if ( temp == 0) step = 1; 
            if (temp == nRows-1) step = -1; 
            line[index] = new StringBuilder(line[index]).append(sc[i]).toString(); 
            index += step; 
        } 
        StringBuilder sb = new StringBuilder(); 
        for (int i = 0; i<nRows; i++) 
            sb = sb.append(line[i]); 
        return sb.toString(); 
    } 
}