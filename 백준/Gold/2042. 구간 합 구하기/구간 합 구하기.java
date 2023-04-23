import java.math.*;
import java.util.*;
import java.io.*;

public class Main {

    static long [] tree;
    static long [] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 총 노드의 개수
        double e = Math.log(N) / Math.log(2);
        int len = e == Math.floor(e) ? (int) Math.pow(2, (int) e + 1) : (int) Math.pow(2, (int) e + 2);

        tree = new long[len];

        arr = new long[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        makeSegmentTree(1, N, 1);

        for (int i = 0 ; i < M + K ; i++) {
            st = new StringTokenizer(br.readLine());

            int com = Integer.parseInt(st.nextToken());

            if (com == 1) {
                int idx = Integer.parseInt(st.nextToken());
                long num = Long.parseLong(st.nextToken());

                long dif = num - arr[idx];
                arr[idx] = num;
                update(1, N, 1, idx, dif);
            } else {
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                sb.append(sum(1, N, 1, left, right)).append("\n");
            }
        }
        System.out.print(sb);
    }

    static long makeSegmentTree(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = makeSegmentTree(start, mid, node * 2) + makeSegmentTree(mid + 1, end, node * 2 + 1);
    }

    static long sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    static void update(int start, int end, int node, int idx, long dif) {
        if (idx < start || idx > end) return;
        tree[node] += dif;
        if (start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, dif);
        update(mid + 1, end, node * 2 + 1, idx, dif);
    }
}