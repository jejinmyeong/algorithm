import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s1 = st.nextToken();
        String s2 = st.nextToken();

        int sub = Math.abs(s1.length() - s2.length());

        int ans = Integer.MAX_VALUE;
        for (int i = 0 ; i <= sub ; i++) {
            int cnt = 0;
            for (int j = 0 ; j < s1.length() ; j++) {
                if (s1.charAt(j) != s2.charAt(j + i)) cnt++;
            }
            ans = Math.min(ans, cnt);
        }

        System.out.println(ans);
    }
}