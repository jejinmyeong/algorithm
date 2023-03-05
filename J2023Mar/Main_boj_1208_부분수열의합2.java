package J2023Mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_boj_1208_부분수열의합2 {
    static int [] seq;
    static long ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        seq = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        dfs(0, 0, N/2, left);
        dfs(0, N/2, N, right);

        Collections.sort(left);
        Collections.sort(right);

        solution(left, right, S);

        System.out.println(S == 0 ? ans - 1 : ans);
    }

    static void solution (ArrayList<Integer> left, ArrayList<Integer> right, int S) {
        int start = 0;
        int end = right.size() - 1;

        while (true) {
            if (start == left.size() || end < 0) break;

            int l = left.get(start);
            int r = right.get(end);

            if (l + r == S) {
                long lc = 0;
                while (start < left.size() && left.get(start) == l) {
                    lc++;
                    start++;
                }

                long rc = 0;
                while (end >= 0 && right.get(end) == r) {
                    rc++;
                    end--;
                }

                ans += lc * rc;
            }
            if (l + r > S) end--;
            if (l + r < S) start++;
        }

    }

    static void dfs (int sum, int start, int end, ArrayList<Integer> list) {
        if (start == end) {
            list.add(sum);
            return;
        }

        dfs(sum + seq[start], start + 1, end, list);
        dfs(sum, start + 1, end, list);
    }
}
