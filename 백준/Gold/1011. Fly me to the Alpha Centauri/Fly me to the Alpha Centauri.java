import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0 ; tc < T ; tc++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int d = M - N;

            int max = (int) Math.sqrt(d);

            if (max == Math.sqrt(d)) {
                sb.append(max * 2 - 1).append("\n");
            } else if (d > max * max + max) {
                sb.append(max * 2 + 1).append("\n");
            } else if (max < Math.sqrt(d)) {
                sb.append(max * 2).append("\n");
            }

        }
        System.out.print(sb);
    }
}