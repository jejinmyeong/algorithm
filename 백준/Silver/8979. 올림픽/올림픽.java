import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    static class Nation implements Comparable<Nation> {
        int g, s, b;
        Nation(int g, int s, int b) {
            this.g = g;
            this.s = s;
            this.b = b;
        }

        @Override
        public int compareTo(Nation o) {
            if (this.g == o.g && this.s == o.s) return this.b - o.b;
            if (this.g == o.g) return this.s - o.s;
            return this.g - o.g;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Nation [] nations = new Nation[N + 1];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nations[idx] = new Nation(g, s, b);
        }

        int ans = 1;

        for (int i = 1 ; i < K ; i++) {
            if (nations[i].compareTo(nations[K]) > 0) ans++;
        }

        for (int i = K + 1 ; i < N ; i++) {
            if (nations[i].compareTo(nations[K - 1]) > 0) ans++;
        }

        System.out.println(ans);

    }
}
