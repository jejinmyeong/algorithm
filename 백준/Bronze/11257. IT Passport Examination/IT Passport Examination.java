import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int sum = a + b + c;
            sb.append(n).append(" ").append(sum).append(" ");

            if (sum >= 55 && a >= 11 && b >= 8 && c >= 12) sb.append("PASS\n");
            else sb.append("FAIL\n");
        }

        System.out.println(sb);
    }
}
