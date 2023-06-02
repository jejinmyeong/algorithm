import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    static int N;
    static long [] tree, arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        double e = Math.log(N) / Math.log(2);
        int len = e == Math.floor(e) ? (int) Math.pow(2, (int) e + 1) : (int) Math.pow(2, (int) e + 2);

        tree = new long[len];
        arr = new long[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        initTree(1, N, 1);

        for (int i = 0 ; i < M + K ; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                update(1, N, 1, b, c);
            } else {
                sb.append(multiple(1, N, 1, b, c)).append("\n");
            }
        }

        System.out.print(sb);
    }

    static long initTree(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = (initTree(start, mid, node * 2) * initTree(mid + 1 , end, node * 2 + 1)) % 1_000_000_007;
    }

    static long multiple(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return 1L;
        if (left <= start && right >= end) return tree[node];
        int mid = (start + end) / 2;
        return (multiple(start, mid, node * 2, left, right) * multiple(mid + 1, end, node * 2 + 1, left, right)) % 1_000_000_007;
    }

    static long update(int start, int end, int node, int idx, long dif) {
        if (idx < start || idx > end) return tree[node];
        if (start == end) return tree[node] = dif;
        int mid = (start + end) / 2;
        return tree[node] = (update(start, mid, node * 2, idx, dif) * update(mid + 1, end, node * 2 + 1, idx, dif)) % 1_000_000_007;
    }
}
