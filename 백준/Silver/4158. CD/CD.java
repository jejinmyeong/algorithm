import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            HashSet<Integer> set = new HashSet<>();

            for (int i = 0 ; i < N ; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }

            int cnt = 0;

            for (int j = 0 ; j < M ; j++) {
                if (set.contains(Integer.parseInt(br.readLine()))) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);

    }
}