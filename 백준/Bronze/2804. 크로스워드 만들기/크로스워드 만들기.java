import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str1 = st.nextToken();
        String str2 = st.nextToken();

        int x = -1;
        int y = -1;

        loop: for (int i = 0 ; i < str1.length() ; i++) {
            for (int j = 0 ; j < str2.length() ; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    y = i;
                    x = j;
                    break loop;
                }
            }
        }

        for (int i = 0 ; i < str2.length() ; i++) {
            for (int j = 0 ; j < str1.length() ; j++) {
                if (i == x) {
                    sb.append(str1.charAt(j));
                } else if (j == y) {
                    sb.append(str2.charAt(i));
                } else {
                    sb.append('.');
                }

            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
