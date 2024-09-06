import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            int total = c * p - (c - 1) * 2;

            sb.append(c + " " + p).append("\n");
            sb.append(total).append("\n");
        }

        System.out.print(sb);
    }
}
