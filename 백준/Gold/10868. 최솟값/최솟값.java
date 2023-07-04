import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int N;
    static int [] tree, arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        double log2N = Math.log(N) / Math.log(2);

        int depth = log2N == Math.floor(log2N) ? (int) log2N + 1 : (int) log2N + 2;

        tree = new int[(int) Math.pow(2, depth) + 1];
        Arrays.fill(tree, Integer.MAX_VALUE);

        arr = new int[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        makeTree(1, N, 1);

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(getMinValue(1, N, start, end, 1)).append("\n");
        }

        System.out.print(sb);
    }

    static int makeTree(int left, int right, int node) {
        if (left == right) return tree[node] = arr[left];

        int mid = (left + right) / 2;
        return tree[node] = Math.min(makeTree(left, mid, node * 2), makeTree(mid + 1, right, node * 2 + 1));
    }

    static int getMinValue(int left, int right, int start, int end, int node) {
        if (left > end || right < start) return Integer.MAX_VALUE;

        if (left >= start && right <= end) return tree[node];

        int mid = (left + right) / 2;

        return Math.min(getMinValue(left, mid, start, end, node * 2), getMinValue(mid + 1, right, start, end, node * 2 + 1));
    }
}

