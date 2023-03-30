import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Want [] wants = new Want[M];

            for (int i = 0 ; i < M ; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                wants[i] = new Want(a, b);
            }

            Arrays.sort(wants);

            int ans = 0;
            boolean [] visited = new boolean[N + 1];

            for (int i = 0 ; i < M ; i++) {
                Want now = wants[i];

                for (int j = now.a ; j <= now.b ; j++) {
                    if (visited[j]) continue;
                    visited[j] = true;
                    ans++;
                    break;
                }
            }


            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }

    static class Want implements Comparable<Want> {
        int a, b;
        Want(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Want o) {
            if (this.b == o.b) return this.a - o.a;
            return this.b - o.b;
        }
    }
}


