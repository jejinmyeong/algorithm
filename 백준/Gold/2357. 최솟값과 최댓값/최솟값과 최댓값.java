import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int max, min;
        Node(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }

    static Node [] tree;
    static int [] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        double e = Math.log(N) / Math.log(2);
        int len = e == Math.floor(e) ? (int) Math.pow(2, (int) e + 1) : (int) Math.pow(2, (int) e + 2);

        tree = new Node[len];

        makeSegmentTree(1, N, 1);

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            Node res = getValue(1, N, 1, left, right);

            sb.append(res.min + " " + res.max).append("\n");
        }

        System.out.print(sb);

    }
    static Node makeSegmentTree(int start, int end, int node) {
        if (start == end) return tree[node] = new Node(arr[start], arr[start]);
        int mid = (start + end) / 2;
        Node left = makeSegmentTree(start, mid, node * 2);
        Node right = makeSegmentTree(mid + 1, end, node * 2 + 1);
        return tree[node] = new Node(Math.max(left.max, right.max), Math.min(left.min, right.min));
    }

    static Node getValue(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return new Node(0, Integer.MAX_VALUE);
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        Node l = getValue(start, mid, node * 2 , left, right);
        Node r = getValue(mid + 1, end, node * 2 + 1, left, right);
        return new Node(Math.max(l.max, r.max), Math.min(l.min, r.min));
    }
}