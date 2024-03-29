import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static class Food {
        int p, f, s, v, c;

        Food (int p, int f, int s, int v, int c) {
            this.p = p;
            this.f = f;
            this.s = s;
            this.v = v;
            this.c = c;
        }
    }

    static int mp, mf, ms, mv, min, N;
    static ArrayList<Integer> list;
    static Food [] foods;
    static boolean [] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        foods = new Food[N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            foods[i] = new Food(p, f, s, v, c);
        }

        visited = new boolean[N];
        list = new ArrayList<>();
        min = Integer.MAX_VALUE;

        bt(0, 0, 0, 0, 0, 0);

        sb.append(min).append("\n");

        for (int i: list) {
            sb.append(i + 1).append(" ");
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(sb);
    }

    static void bt(int p, int f, int s, int v, int c, int idx) {
        if (min <= c) return;

        if (mp <= p && mf <= f && ms <= s && mv <= v) {
            min = c;
            list.clear();
            for (int i = 0 ; i < N ; i++) {
                if (visited[i]) list.add(i);
            }
            return;
        }

        if (idx == N) return;


        for (int i = idx ; i < N ; i++) {
            Food now = foods[i];

            visited[i] = true;
            bt (p + now.p, f + now.f, s + now.s, v + now.v, c + now.c, i + 1);
            visited[i] = false;
        }
    }

}