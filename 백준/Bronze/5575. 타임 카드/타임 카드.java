import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < 3 ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) * 60 * 60 + Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) * 60 * 60 + Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());

            int dist = end - start;

            int h = dist / 60 / 60;
            sb.append(h).append(" ");
            dist -= h * 60 * 60;

            int m = dist / 60;
            sb.append(m).append(" ");
            dist -= m * 60;

            sb.append(dist).append("\n");
        }

        System.out.print(sb);
    }
}