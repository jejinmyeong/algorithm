import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        String input;
        
        while((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            
            char [] s = st.nextToken().toCharArray();
            char [] t = st.nextToken().toCharArray();
            
            int si = 0;
            int ti = 0;
            
            while (si < s.length && ti < t.length) {
                if (s[si] == t[ti]) {
                    si++;
                }
                ti++;
            }
            
            if (si == s.length) sb.append("Yes");
            else sb.append("No");
            
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}