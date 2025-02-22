import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int [] player;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

            if (N == 0 || M == 0) {
                break;
            }

            int first = Integer.MIN_VALUE;
            int second = Integer.MIN_VALUE;

            player = new int[10001];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int num = Integer.parseInt(st.nextToken());

                    player[num]++;
                }
            }

            for (int i = 0; i < 10001; i++) {
                first = Math.max(first, player[i]);
            }

            for (int i = 0; i < 10001; i++) {
                if (first != player[i]) {
                    second = Math.max(second, player[i]);
                }
            }

            for (int i = 0 ; i < 10001; i++) {
                if (second == player[i]) {
                    sb.append(i + " ");
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}