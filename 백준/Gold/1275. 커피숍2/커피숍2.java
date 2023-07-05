import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static long [] tree, arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        double log2N = Math.log(N) / Math.log(2);

        int depth = log2N == Math.floor(log2N) ? (int) log2N + 1 : (int) log2N + 2;

        arr = new long[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tree = new long[(int) Math.pow(2, depth) + 1];

        makeTree(1, N, 1);

        for (int i = 0 ; i < Q ; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(getSumValue(1, N, Math.min(x, y), Math.max(x, y), 1)).append("\n");

            long sub = b - arr[a];
            arr[a] = b;

            update(1, N, a, sub, 1);
        }

        System.out.print(sb);

    }

    static long makeTree(int left, int right, int node) {
        if (left == right) return tree[node] = arr[left];

        int mid = (left + right) / 2;

        return tree[node] = makeTree(left, mid, node * 2) + makeTree(mid + 1, right, node * 2 + 1);
    }

    static long getSumValue(int left, int right, int start, int end, int node) {
        if (left > end || right < start) return 0;

        if (left >= start && right <= end) return tree[node];

        int mid = (left + right) / 2;

        return getSumValue(left, mid, start, end, node * 2) + getSumValue(mid + 1, right, start, end, node*2 + 1);
    }

    static void update(int left, int right, int index, long sub, int node) {
        if (left > index || right < index) return;

        tree[node] += sub;

        if (left == right) return;

        int mid = (left + right) / 2;

        update(left, mid, index, sub, node * 2);
        update(mid + 1, right, index, sub, node * 2 + 1);
    }
}