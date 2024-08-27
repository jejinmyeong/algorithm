import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while (n-- > 0) {
            int l = Integer.parseInt(st.nextToken());

            if (l >= 300) {
                sb.append(1);
            } else if (300 > l && l >= 275) { 
                sb.append(2);
            } else if (275 > l && l >= 250) {
                sb.append(3);
            } else {
                sb.append(4);
            }

            sb.append(" ");
        }

        System.out.println(sb);
    }
}
